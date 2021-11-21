package com.forfun.IssueConsole.services

import android.text.TextUtils
import android.util.Log
import com.huawei.hms.push.HmsMessageService


class HWService : HmsMessageService() {
    override fun onNewToken(token: String) {
        Log.e("HW_Token", "Refreshed token: $token")
        // send the token to your app server.
        if (!TextUtils.isEmpty(token)) {
            sendRegTokenToServer(token)
        }
    }

    private fun sendRegTokenToServer(token: String) {
        Log.e("HW_Token", "Service get token:$token")
    }
}
