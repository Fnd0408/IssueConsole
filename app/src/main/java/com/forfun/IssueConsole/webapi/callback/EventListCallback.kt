package com.forfun.IssueConsole.webapi.callback

import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.MainActivity
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.models.webapiModels.EventListResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventListCallback(private var mContext: MainActivity) : Callback<EventListResponse> {
    override fun onResponse(call: Call<EventListResponse>, response: Response<EventListResponse>) {
        try {
            when (response.code()) {
                200 -> {
                    //mContext.refreshData(response.body()!!)
                }
                403, 404, 500 -> {
                    try {
                        val getError = JSONObject(response.errorBody()!!.string())
                        ErrorHandle.setCode(
                            response.code(),
                            getError.getString("msg").split("!!")[0],
                            mContext
                        )
                        if (getError.getString("msg").split("!!")[0].contains("事件處理中"))
                            mContext.getEventList()
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
        } finally {
            ShowAlert.Loading(false)
            mContext.refreshAction.isRefreshing = false
        }
    }

    override fun onFailure(call: Call<EventListResponse>, t: Throwable) {
        ShowAlert.Loading(false)
        ShowAlert.TipMsg(mContext, mContext.getString(R.string.error_network))
        t.printStackTrace()
        mContext.refreshAction.isRefreshing = false
    }
}
