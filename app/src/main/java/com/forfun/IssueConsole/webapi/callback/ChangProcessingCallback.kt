package com.forfun.IssueConsole.webapi.callback

import android.widget.Toast
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.MainActivity
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.models.webapiModels.BaseModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangProcessingCallback(private var mContext: MainActivity) : Callback<BaseModel> {
    override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
        try {
            when (response.code()) {
                200 -> {
                    Toast.makeText(mContext, "狀態更新", Toast.LENGTH_SHORT).show()
                    mContext.getEventList()
                }
                403, 404, 500 -> {
                    try {
                        val getError = JSONObject(response.errorBody()!!.string())
                        ErrorHandle.setCode(
                            response.code(),
                            getError.getString("msg").split("!!")[0],
                            mContext
                        )
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

    override fun onFailure(call: Call<BaseModel>, t: Throwable) {
        ShowAlert.Loading(false)
        ShowAlert.TipMsg(mContext, mContext.getString(R.string.error_network))
        t.printStackTrace()
    }
}
