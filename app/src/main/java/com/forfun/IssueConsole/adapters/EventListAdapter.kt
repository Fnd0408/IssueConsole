package com.forfun.IssueConsole.adapters

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.MainActivity
import com.forfun.IssueConsole.functions.Prefs
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.localdata.db.EventDatabase
import com.forfun.IssueConsole.models.webapiModels.EventContent
import java.text.SimpleDateFormat
import java.util.*

class EventListAdapter(private val mContext: MainActivity, private val data: List<EventContent>) :
    RecyclerView.Adapter<EventListAdapter.ViewHolder>() {
    var isClosed = false
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.adapter_main, parent, false)
        val holder = ViewHolder(view)
        holder.tvTitle = view.findViewById(R.id.tvTitle)
        holder.tvContent = view.findViewById(R.id.tvContent)
        holder.tvProcessing = view.findViewById(R.id.tvProcessing)
        holder.btnProcessing = view.findViewById(R.id.processing)
        holder.btnFinish = view.findViewById(R.id.finish)
        holder.btnCancel = view.findViewById(R.id.cancel)
        holder.cardView = view.findViewById(R.id.cardView)
        holder.tvBadge = view.findViewById(R.id.tvBadge)
        holder.tvStatus = view.findViewById(R.id.tvStatus)
        holder.tvTime = view.findViewById(R.id.tvTime)
        holder.tvRealContent = view.findViewById(R.id.tv_content)
        return holder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = data[position]
        val processType = mContext.resources.getStringArray(R.array.processing_type)
        holder.itemView.setOnClickListener {
            isShowContent(holder.itemView)
        }
        holder.itemView.setOnLongClickListener {
            ShowAlert.TipMsg(
                mContext,
                "Please confirm delete file or not?",
                DialogInterface.OnClickListener { _, _ ->
                    deleteEvent(model.EVENT_ID)
                })
            true
        }
        holder.tvRealContent!!.setOnClickListener {
            isShowContent(holder.itemView)
        }
        holder.tvTitle!!.text = model.EVENT_TITLE
        holder.tvContent!!.text = model.EVENT_CONTENT
        holder.btnProcessing!!.visibility = View.GONE
        holder.btnCancel!!.visibility = View.GONE
        holder.btnFinish!!.visibility = View.GONE

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val oldTime = parser.parse(model.EVENT_CREATEDATE)
        val nowTime = Date()
        holder.tvRealContent!!.text =
            model.EVENT_CONTENT + "\n\n" + model.EVENT_CREATEDATE.replace("T", " ")
        val days = ((nowTime.time - oldTime.time) / (1000 * 60 * 60 * 24))
        holder.tvTime!!.text = "$days Days"
//        holder.tvBadge!!.text = model.EVENT_TITLE.subSequence(0, 1)
        when (model.EVENT_LEVEL) {
            1 -> {
                holder.tvBadge!!.setBackgroundResource(R.drawable.bg_text_circle_blue)
            }
            2 -> {
                holder.tvBadge!!.setBackgroundResource(R.drawable.bg_text_circle_yellow)
            }
            else -> {
                holder.tvBadge!!.setBackgroundResource(R.drawable.bg_text_circle_red)
            }
        }
        val dept =
            when {
                model.PROCESSING_PEOPLE_DEPT == null -> ""
                model.PROCESSING_PEOPLE_DEPT.split("_")
                    .count() >= 2 -> model.PROCESSING_PEOPLE_DEPT.split(
                    "_"
                )[1]
                else -> model.PROCESSING_PEOPLE_DEPT.split("_")[0]
            }
        val name = when {
            model.PROCESSING_PEOPLE_NAME == null -> ""
            model.PROCESSING_PEOPLE_NAME.split("_")
                .count() >= 2 -> model.PROCESSING_PEOPLE_NAME.split(
                "_"
            )[1]
            else -> model.PROCESSING_PEOPLE_NAME.split("_")[0]
        }
        val processingStatus = if (dept != "") dept + "_" + name else name
        holder.tvProcessing!!.text =
            mContext.getString(R.string.processing_status) +
                    processingStatus +
                    " " + processType[model.PROCESSING_TYPE.toInt()]
        holder.tvStatus!!.visibility = View.INVISIBLE
        //若事件處理中且處理者非使用者
        if ((model.PROCESSING_TYPE.toInt() != 0 && model.PROCESSING_PEOPLE_ID != Prefs.GetMain(
                mContext,
                "account"
            )) || model.PROCESSING_TYPE.toInt() == 3
        ) {
            holder.tvProcessing!!.visibility = View.VISIBLE
        } else if (model.PROCESSING_TYPE.toInt() != 0 && model.PROCESSING_PEOPLE_ID == Prefs.GetMain(
                mContext,
                "account"
            )
        ) {
            holder.tvProcessing!!.visibility = View.GONE
            holder.tvStatus!!.visibility = View.VISIBLE
        } else
            holder.tvProcessing!!.visibility = View.GONE
        holder.btnProcessing!!.setOnClickListener {
            updateProcessingStatus(model.EVENT_ID, 1)
        }
        holder.btnCancel!!.setOnClickListener {
            updateProcessingStatus(model.EVENT_ID, 0)
        }
        holder.btnFinish!!.setOnClickListener {
            var listener = DialogInterface.OnClickListener { dialog, which ->
                updateProcessingStatus(
                    model.EVENT_ID,
                    3
                )
            }
            ShowAlert.TipMsg(mContext, "Wanna finish this issue?", listener)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView? = null
        var tvContent: TextView? = null
        var tvProcessing: TextView? = null
        var btnProcessing: Button? = null
        var btnFinish: Button? = null
        var btnCancel: Button? = null
        var cardView: CardView? = null
        var tvBadge: ImageView? = null
        var tvStatus: TextView? = null
        var tvTime: TextView? = null
        var tvRealContent: TextView? = null
    }

    private fun updateProcessingStatus(eventId: String, status: Int) {
        var db = Room.databaseBuilder(mContext, EventDatabase::class.java, "LocalEvent")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        var event = db.eventDao!!.getEvent(eventId)
        if(event!!.PROCESSING_TYPE.toInt() != 0 && event.PROCESSING_PEOPLE_ID != Prefs.GetMain(mContext,"account")) {
            Toast.makeText(mContext,event.PROCESSING_PEOPLE_ID + " is processing now.",Toast.LENGTH_SHORT).show()
        }
        else{
            event.PROCESSING_TYPE = status.toByte()
            event.PROCESSING_PEOPLE_ID = Prefs.GetMain(mContext,"account")
            db.eventDao!!.update(event)
            mContext.getEventList()
        }
    }

    private fun deleteEvent(eventId: String) {
        var db = Room.databaseBuilder(mContext, EventDatabase::class.java, "LocalEvent")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        db.eventDao!!.delete(db.eventDao!!.getEvent(eventId))
        mContext.getEventList()
    }

    private fun isShowContent(view: View) {
        if (isClosed)
            view.findViewById<ScrollView>(R.id.scroll).visibility = View.GONE
        else
            view.findViewById<ScrollView>(R.id.scroll).visibility = View.VISIBLE
        isClosed = !isClosed
    }
}
