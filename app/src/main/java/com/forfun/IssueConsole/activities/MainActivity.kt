package com.forfun.IssueConsole.activities

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.adapters.EventListAdapter
import com.forfun.IssueConsole.functions.Prefs
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.localdata.db.EventDatabase
import com.forfun.IssueConsole.models.webapiModels.BaseModel
import com.forfun.IssueConsole.models.webapiModels.EventContent
import com.forfun.IssueConsole.models.webapiModels.SaveTokenRequest
import com.forfun.IssueConsole.webapi.RetrofitBase
import com.forfun.IssueConsole.webapi.callback.SaveTokenCallback
import com.forfun.IssueConsole.webapi.interfaces.Event
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.huawei.hms.aaid.HmsInstanceId
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import java.time.LocalDateTime
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    val handler = Handler()
    private lateinit var localEvent: List<com.forfun.IssueConsole.localdata.model.Event?>
    private var isFinished by Delegates.notNull<Boolean>()
    private lateinit var prefs: SharedPreferences
    private lateinit var db: EventDatabase
    private var viewData: MutableList<EventContent> = mutableListOf()

    //    lateinit var refresh : Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        db = Room.databaseBuilder(this, EventDatabase::class.java, "LocalEvent")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        prefs = getSharedPreferences("profile", Context.MODE_PRIVATE)
        //fab add event
        fab.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            var view = layoutInflater.inflate(R.layout.alert_event, null)
            view.findViewById<Spinner>(R.id.level_spinner).adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                resources.getStringArray(R.array.level_type)
            )
            //Save Event
            alert.setPositiveButton("Save") { dialog, _ ->
                var testEvent = com.forfun.IssueConsole.localdata.model.Event()
                testEvent.EVENT_TITLE = view.findViewById<EditText>(R.id.event_title).text.toString()
                testEvent.EVENT_LEVEL =
                    view.findViewById<Spinner>(R.id.level_spinner).selectedItemPosition + 1
                testEvent.EVENT_CONTENT =
                    view.findViewById<EditText>(R.id.event_content).text.toString()
                testEvent.EVENT_CREATEDATE = LocalDateTime.now().toString()
                testEvent.EVENT_CREATOR = Prefs.GetMain(this, "account")
                testEvent.PROCESSING_TYPE = 0
                db.eventDao!!.insert(testEvent)
                dialog.cancel()
            }
            //Cancel Event
            alert.setNeutralButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            alert.setView(view)
            alert.show()

        }

        //先去找華為Token
        //getHWToken()
        //toolbar
        toolbar.inflateMenu(R.menu.filter)
        toolbar.setOnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.action_filter -> {
                    val mDialogView = LayoutInflater.from(this).inflate(R.layout.alert_filter, null)
                    //init
                    when (prefs.getInt("filter_day", -7)) {
                        -1 -> mDialogView.findViewById<RadioButton>(R.id.day_rb1).isChecked = true
                        -7 -> mDialogView.findViewById<RadioButton>(R.id.day_rb2).isChecked = true
                        -30 -> mDialogView.findViewById<RadioButton>(R.id.day_rb3).isChecked = true
                    }
                    mDialogView.findViewById<Switch>(R.id.isDone).isChecked =
                        prefs.getBoolean("filter_isDone", false)
                    mDialogView.findViewById<EditText>(R.id.et_count)
                        .setText(prefs.getInt("filter_count", 100).toString())
                    //添加事件檢查輸入值為整數
                    mDialogView.findViewById<EditText>(R.id.et_count)
                        .addTextChangedListener(object :
                            TextWatcher {
                            override fun afterTextChanged(s: Editable?) {
                                try {
                                    mDialogView.findViewById<EditText>(R.id.et_count)
                                        .text.toString().toInt()
                                } catch (ex: Exception) {
                                    mDialogView.findViewById<EditText>(R.id.et_count).setText("100")
                                }
                            }

                            override fun beforeTextChanged(
                                s: CharSequence?,
                                start: Int,
                                count: Int,
                                after: Int
                            ) {
                            }

                            override fun onTextChanged(
                                s: CharSequence?,
                                start: Int,
                                before: Int,
                                count: Int
                            ) {
                            }
                        })
                    val spinnerArrayAdapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        resources.getStringArray(R.array.error_type)
                    )
                    mDialogView.findViewById<Spinner>(R.id.spinner).adapter = spinnerArrayAdapter
                    mDialogView.findViewById<Spinner>(R.id.spinner)
                        .setSelection(prefs.getInt("filter_level", 0))
                    //init

                    val mBuilder = AlertDialog.Builder(this)
                        .setView(mDialogView)
                    val creator = mBuilder.create()
                    mDialogView.findViewById<Button>(R.id.btn_ok).setOnClickListener {
                        val editor = prefs.edit()
                        when {
                            mDialogView.findViewById<RadioButton>(R.id.day_rb1).isChecked -> editor.putInt(
                                "filter_day",
                                -1
                            )
                            mDialogView.findViewById<RadioButton>(R.id.day_rb2).isChecked -> editor.putInt(
                                "filter_day",
                                -7
                            )
                            mDialogView.findViewById<RadioButton>(R.id.day_rb3).isChecked -> editor.putInt(
                                "filter_day",
                                -30
                            )
                        }
                        editor.putBoolean(
                            "filter_isDone",
                            mDialogView.findViewById<Switch>(R.id.isDone).isChecked
                        )
                        editor.putInt(
                            "filter_count",
                            mDialogView.findViewById<EditText>(R.id.et_count).text.toString()
                                .toInt()
                        )
                        editor.putInt(
                            "filter_level",
                            mDialogView.findViewById<Spinner>(R.id.spinner).selectedItemPosition
                        )
                        editor.apply()
                        creator.dismiss()
                        getEventList()
                    }
                    creator.show()
                }
            }
            true
        }
        //status bar color
        val window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        refreshAction.setOnRefreshListener {
            getEventList()
        }
        dataList.setItemViewCacheSize(10000)
    }

    override fun onBackPressed() {
        //Check Logout
        ShowAlert.TipMsg(this, "Logout?", DialogInterface.OnClickListener { dialog, which ->
            super.onBackPressed()
            Prefs.SetMain(this, "token", "")
            if (!Prefs.GetMainBoolean(this, "isRemember")) {
                Prefs.cleanData(this)
                Prefs.SetTestUrl(this, true)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getEventList()
        listenChannel()
        //Firebase Token
        //getToken()
    }

    //get Event Data
    fun getEventList() {
        isFinished = prefs.getBoolean("filter_isDone", false)
        localEvent = if (isFinished)
            db.eventDao!!.getAllFinishedEvents()
        else
            db.eventDao!!.getAllEvents()
        viewData = mutableListOf()
        if (localEvent.isNotEmpty()) {
            for (item in localEvent) {
                viewData.add(
                    EventContent(
                        EVENT_CONTENT = item!!.EVENT_CONTENT,
                        EVENT_CREATEDATE = item.EVENT_CREATEDATE,
                        EVENT_CREATOR = item.EVENT_CREATOR,
                        EVENT_ID = item.Event_ID.toString(),
                        EVENT_LEVEL = item.EVENT_LEVEL,
                        EVENT_TITLE = item.EVENT_TITLE,
                        PROCESSING_PEOPLE_DEPT = item.PROCESSING_PEOPLE_DEPT,
                        PROCESSING_PEOPLE_ID = item.PROCESSING_PEOPLE_ID,
                        PROCESSING_PEOPLE_NAME = item.PROCESSING_PEOPLE_NAME,
                        PROCESSING_TYPE = item.PROCESSING_TYPE
                    )
                )
            }
        }
        refreshData(viewData)
    }

    //Refresh View
    private fun refreshData(eventList: List<EventContent>) {
        val llm = LinearLayoutManager(this)
        llm.orientation = RecyclerView.VERTICAL
        dataList.layoutManager = llm
        dataList.adapter = EventListAdapter(this, eventList)
        refreshAction.isRefreshing = false
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                //  up down callback
                return true
            }

            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = 0
                val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == 4)
                    if (viewHolder.itemView.findViewById<TextView>(R.id.tvStatus).visibility == View.INVISIBLE)
                        viewHolder.itemView.findViewById<Button>(R.id.processing).callOnClick()
                    else
                        viewHolder.itemView.findViewById<Button>(R.id.cancel).callOnClick()
                else if (direction == 8)
                    viewHolder.itemView.findViewById<Button>(R.id.finish).callOnClick()
                dataList.adapter!!.notifyDataSetChanged()
            }
        }).attachToRecyclerView(dataList)
        dataList.adapter!!.notifyDataSetChanged()
    }

    //For Google Service Notification
    private fun getToken() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.e("FCM_Token", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result?.token
                //回寫Token
                val event = RetrofitBase.outsideConnection(this).create(Event::class.java)
                var body = SaveTokenRequest(
                    USER_ID = Prefs.GetMain(this, "userId"),
                    UPDATE_TIME = LocalDateTime.now().toString(),
                    OS_TOKEN = "",
                    ANDROID_TOKEN = token.toString(),
                    IOS_TOKEN = "",
                    WEB_TOKEN = ""
                )
                val call: Call<BaseModel> =
                    event.saveAndroidToken(Prefs.GetMain(this, "token"), body)
                ShowAlert.InitProcess(this)
                ShowAlert.Loading(true)
                call.enqueue(SaveTokenCallback(this))
            })
    }

    //Listen Firebase Channel
    private fun listenChannel() {
        FirebaseMessaging.getInstance().subscribeToTopic("News")
            .addOnCompleteListener { task ->
                var msg = getString(R.string.listen_success)
                if (!task.isSuccessful) {
                    msg = getString(R.string.listen_fail)
                }
                Log.e("FCM_Channel", msg)
            }
    }

    //Huiwei Notification
    private fun getHWToken() {
        Thread {
            try {
                val getToken = HmsInstanceId.getInstance(this).getToken("101640091", "HCM")
                if (!TextUtils.isEmpty(getToken)) {
                    Log.e("HW_Token", "Activity get token:$getToken")
                }
            } catch (e: java.lang.Exception) {
                Log.e("HW_Push", "getToken failed.", e)
            }
        }.start()
    }

}
