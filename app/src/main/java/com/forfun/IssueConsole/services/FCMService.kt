package com.forfun.IssueConsole.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FCMService : FirebaseMessagingService() {
    private val Tag = "FCM"
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(Tag, "From: " + remoteMessage.from!!)
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(Tag, "Message data payload: " + remoteMessage.data)

            if (true) {
                scheduleJob()
            } else {
                handleNow()
            }
        }
        if (remoteMessage.notification != null) {
            Log.d(Tag, "Message Notification Body: " + remoteMessage.notification!!.body!!)
        }
    }

    private fun handleNow() {
    }

    private fun scheduleJob() {

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }
}
