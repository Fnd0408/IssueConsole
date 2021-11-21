package com.forfun.IssueConsole.webapi.callback

import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.MainActivity
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.models.webapiModels.BaseModel
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SaveTokenCallback(private var mContext: MainActivity) : Callback<BaseModel> {
    override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
        try {
            when (response.code()) {

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
//                        mContext.removeHandler()
                    }
                }
            }
        } catch (ex: Exception) {
            if (ex.message == null || ex.message!!.contains("null"))
                Feedback.ApiError(mContext, ex.message)
            else
                Feedback.AppError(mContext, ex.message)
            ex.printStackTrace()
//            mContext.removeHandler()
        }
    }

    override fun onFailure(call: Call<BaseModel>, t: Throwable) {
        ShowAlert.Loading(false)
        ShowAlert.TipMsg(mContext, mContext.getString(R.string.error_network))
        t.printStackTrace()
        mContext.refreshAction.isRefreshing = false
    }
}
