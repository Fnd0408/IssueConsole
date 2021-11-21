package com.forfun.IssueConsole.services

import android.content.Context
import android.content.Intent
import androidx.legacy.content.WakefulBroadcastReceiver
import android.media.MediaPlayer
import com.forfun.IssueConsole.R


@Suppress("DEPRECATION")
class VoiceService : WakefulBroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val mp = MediaPlayer.create(context, R.raw.alert)
        mp.start()
    }
}
