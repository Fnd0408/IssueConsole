package com.forfun.IssueConsole.activities

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.util.Log
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.functions.Prefs
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        try {
            val pInfo = this.packageManager.getPackageInfo(packageName, 0)
            version.text = "ver." + pInfo.versionName
            if (Prefs.GetTestUrl(this))
                version.text = version.text.toString() + "(Test)"
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        //當版本低於9.0將無法使用指紋辨識
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
//            Prefs.SetMainBoolean(this, "isRemember", false)
//            remember_pwd.isChecked = false
//            remember_pwd.visibility = View.INVISIBLE
//        }
        btn_login.setOnClickListener {
            loginEvent(
                account.text.toString(),
                password.text.toString(),
                "Skyline",
                remember_pwd.isChecked
            )
        }

        var waitTime = 0L
        version.setOnTouchListener { _, m ->
            when (m.action) {
                MotionEvent.ACTION_DOWN -> waitTime = System.currentTimeMillis()
                MotionEvent.ACTION_UP -> {
                    if (System.currentTimeMillis() - waitTime > 2000) {
                        val loginBG: ConstraintLayout = findViewById(R.id.login_bg)
                        if (!Prefs.GetTestUrl(this)) {
                            //轉換成測試區
                            Prefs.SetTestUrl(this, true)
                            Prefs.SetUrl(this, resources.getString(R.string.test_out_url))
                            Toast.makeText(this, "You are entering test mode now.", Toast.LENGTH_SHORT).show()
                            val pInfo = this.packageManager.getPackageInfo(packageName, 0)
                            version.text = "ver." + pInfo.versionName + "(Test)"
                        } else {
                            //轉換成正式區
                            Prefs.SetTestUrl(this, false)
                            Prefs.SetUrl(this, resources.getString(R.string.prod_out_url))
                            loginBG.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                            Toast.makeText(this, "Back to district.", Toast.LENGTH_SHORT).show()
                            val pInfo = this.packageManager.getPackageInfo(packageName, 0)
                            version.text = "ver." + pInfo.versionName
                        }
                    }
                }
            }
            true
        }

        if (Prefs.GetMainBoolean(this, "isRemember"))
            remember_pwd.isChecked = true
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
//            && Prefs.GetMainBoolean(this, "isRemember")
//        )
        //fingerManager()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }

    fun loginEvent(account: String, password: String, domain: String, isAuto: Boolean) {
        try {
            Prefs.SetMain(this, "account", account)
            Prefs.SetMain(this, "deptName", "Company")
            Prefs.SetMain(this, "token", "ApiToken")
            if (isAuto)
                setAutoLoginData()
            startActivity(Intent(this,MainActivity::class.java))

        } catch (ex: Exception) {
            finish()
            ex.printStackTrace()
        }
    }

    fun setAutoLoginData() {
        Prefs.SetMain(this, "account", account.text.toString())
        Prefs.SetMain(this, "password", password.text.toString())
        Prefs.SetMain(this, "domain", "Skyline")
        Prefs.SetMainBoolean(this, "isRemember", remember_pwd.isChecked)
    }

    @TargetApi(Build.VERSION_CODES.P)
    private fun fingerManager() {
        val mContext = this
        val mBiometricPrompt = BiometricPrompt.Builder(this)
            .setTitle("指紋驗證")
            .setDescription("Welcome, " + Prefs.GetMain(mContext, "account"))
            .setNegativeButton("取消", mainExecutor,
                DialogInterface.OnClickListener { _, _ ->
                    Log.i(this.localClassName, "Cancel button clicked")
                })
            .build()
        val mCancellationSignal = CancellationSignal()
        mCancellationSignal.setOnCancelListener(object : CancellationSignal.OnCancelListener {
            override fun onCancel() {
                Log.i(this.javaClass.name, "Canceled")
            }
        })
        val mAuthenticationCallback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)

                Log.i(this.javaClass.name, "onAuthenticationError $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                loginEvent(
                    Prefs.GetMain(mContext, "account"),
                    Prefs.GetMain(mContext, "password"),
                    Prefs.GetMain(mContext, "domain"),
                    true
                )
                Log.i(this.javaClass.name, "onAuthenticationSucceeded $result")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Log.i(this.javaClass.name, "onAuthenticationFailed ")
            }
        }
        mBiometricPrompt.authenticate(mCancellationSignal, mainExecutor, mAuthenticationCallback)
    }

    override fun onResume() {
        super.onResume()
        if (Prefs.GetMainBoolean(this, "isRemember")) {
            account.setText(Prefs.GetMain(this, "account"))
            password.setText(Prefs.GetMain(this, "password"))
            if (Prefs.GetMain(this, "token") != "")
                loginEvent(
                    Prefs.GetMain(this, "account"),
                    Prefs.GetMain(this, "password"),
                    Prefs.GetMain(this, "domain"),
                    true
                )
        }
    }
}
