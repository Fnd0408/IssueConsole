package com.forfun.IssueConsole.webapi.callback

import android.content.Intent
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.LoginActivity
import com.forfun.IssueConsole.activities.MainActivity
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.Prefs
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.models.webapiModels.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginCallback(private var mContext: LoginActivity, private var isAuto: Boolean) : Callback<LoginResponse> {
    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        try {
            when (response.code()) {
                200 -> {
                    Prefs.SetMain(mContext, "userId", response.body()!!.content!!.userId)
                    Prefs.SetMain(mContext, "userName", response.body()!!.content!!.username)
                    Prefs.SetMain(mContext, "deptName", response.body()!!.content!!.deptName)
                    Prefs.SetMain(mContext, "token", response.body()!!.content!!.token)
                    if (isAuto)
                        mContext.setAutoLoginData()
                    val intent = Intent()
                    intent.setClass(mContext, MainActivity::class.java)
                    mContext.startActivity(intent)
                }
                401 -> {
                    ShowAlert.TipMsg(mContext, mContext.getString(R.string.login_error))
                }
                404, 500 -> {
                    try {
                        val getError = JSONObject(response.errorBody()!!.string())
                        ErrorHandle.setCode(response.code(), getError.getString("msg").split("!!")[0], mContext)
                    } catch (ex: java.lang.Exception) {
                        Feedback.ApiError(mContext, ex.message)
                    }
                }
            }
        } catch (ex: Exception) {
            if (ex.message == null || ex.message!!.contains("null"))
                Feedback.ApiError(mContext, ex.message)
            else
                Feedback.AppError(mContext, ex.message)
            ex.printStackTrace()
        } finally {
            ShowAlert.Loading(false)
        }
    }

    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        ShowAlert.Loading(false)
        ShowAlert.TipMsg(mContext, mContext.getString(R.string.error_network))
        t.printStackTrace()
    }
}
