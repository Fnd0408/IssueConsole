package com.forfun.IssueConsole.webapi.callback

import android.content.Context
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.ShowAlert.TipMsg
import com.forfun.IssueConsole.functions.ThreadControl


object ErrorHandle {
    fun setCode(code: Int, msg: String, mContext: Context) {
        when (code) {
            401 -> ThreadControl.Logout(mContext)
            404 -> TipMsg(mContext, mContext.getString(R.string.error_404))
            500 -> Feedback.ApiError(mContext, msg)
        }
    }
}
