package com.forfun.IssueConsole.webapi.callback

import android.app.Activity
import android.app.AlertDialog
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.webkit.MimeTypeMap
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.FileProvider
import com.forfun.IssueConsole.BuildConfig
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.activities.InitActivity
import com.forfun.IssueConsole.activities.LoginActivity
import com.forfun.IssueConsole.functions.Feedback
import com.forfun.IssueConsole.functions.ShowAlert
import com.forfun.IssueConsole.models.webapiModels.VersionCheckResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

@Suppress("DEPRECATION")
class CheckVersionCallback(private var mContext: InitActivity) : Callback<VersionCheckResponse> {
    lateinit var file: File
    override fun onResponse(
        call: Call<VersionCheckResponse>,
        response: Response<VersionCheckResponse>
    ) {
        try {
            when (response.code()) {
                200 -> {
                    Log.e("Response", response.body()!!.content.toString())
                    val pInfo = mContext.packageManager.getPackageInfo(mContext.packageName, 0)
                    if (response.body()!!.content.nowVersion != pInfo.versionName && response.body()!!.content.url != "") {
//                    if (response.body()!!.content.isForceUpdate || response.body()!!.content.nowVersion != pInfo.versionName) {
                        showVersionAlert(
                            response.body()!!.content.nowVersion,
                            response.body()!!.content.url,
                            response.body()!!.content.isForceUpdate,
                            response.body()!!.msg
                        )
                    } else {
                        deleteAPK()
                        (mContext as Activity).finish()
                        val intent = Intent()
                        intent.setClass(mContext, LoginActivity::class.java)
                        intent.putExtra("applicationId", 1)
                        mContext.startActivity(intent)
                    }
                }
                404, 500 -> {
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
        }
    }

    override fun onFailure(call: Call<VersionCheckResponse>, t: Throwable) {
        ShowAlert.TipMsg(mContext, mContext.getString(R.string.error_network))
        t.printStackTrace()
    }

    //show version alert,if response force update,can not pass this version check
    private fun showVersionAlert(
        version: String,
        url: String,
        isForced: Boolean,
        versionMsg: String
    ) {
        val msg = versionMsg + "\n\n" +
                if (isForced)
                    mContext.getString(R.string.now_version) + version + mContext.getString(R.string.now_version_forced)
                else
                    mContext.getString(R.string.now_version) + version + mContext.getString(R.string.now_version_notforced)
        AlertDialog.Builder(mContext)
            .setTitle(mContext.getString(R.string.version_change))
            .setMessage(msg)
            .setCancelable(false)
            .setIcon(if (!isForced) R.drawable.ic_tips else R.drawable.ic_warning)
            .setNeutralButton(mContext.getString(R.string.update)) { _, _ ->
                downloadAPK(url)
            }
            .setPositiveButton(mContext.getString(R.string.cancel))
            { _, _ ->
                (mContext as Activity).finish()
                if (!isForced) {
                    val intent = Intent()
                    intent.setClass(mContext, LoginActivity::class.java)
                    intent.putExtra("applicationId", 1)
                    mContext.startActivity(intent)
                }
            }
            .show()
    }

    //download with dm,let user know that he is downloading
    private fun downloadAPK(url: String) {
        try {
            val dmr = DownloadManager.Request(Uri.parse(url))
            val fileName =
                URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url))
            file = File("/storage/emulated/0/Download/$fileName")
            if (file.exists())
                file.delete()
            dmr.setTitle(fileName)
            dmr.setDescription(mContext.getString(R.string.download_context))
            dmr.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
            dmr.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            dmr.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            val dManager = mContext.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mContext.registerReceiver(
                onComplete,
                IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
            )
            dManager.enqueue(dmr)
        } catch (ex: java.lang.Exception) {
            Feedback.AppError(mContext, ex.message)
        }
    }

    //travel download directory to delete old apk version
    private fun deleteAPK() {
        try {
            val dirDownload = File("/storage/emulated/0/Download/")
            if (dirDownload.isDirectory && !dirDownload.listFiles().isNullOrEmpty())
                for (item in dirDownload.listFiles())
                    if (item.name.contains(".apk") && (item.name.contains("ea_")))
                        item.delete()
        } catch (ex: java.lang.Exception) {
            Feedback.AppError(mContext, ex.message)
        }
    }

    //auto launcher that apk
    private val onComplete = object : BroadcastReceiver() {
        override fun onReceive(mContext: Context, intent: Intent) {
            Toast.makeText(
                mContext,
                mContext.getString(R.string.download_complete),
                Toast.LENGTH_SHORT
            ).show()
            val apkFile = file
            val fileLoc: Uri
            //            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val mIntent = Intent(Intent.ACTION_INSTALL_PACKAGE)
            fileLoc = FileProvider.getUriForFile(
                mContext,
                BuildConfig.APPLICATION_ID + ".fileprovider",
                apkFile
            )
//            } else {
//                mIntent = Intent(Intent.ACTION_VIEW)
//                fileLoc = Uri.fromFile(apkFile)
//            }
            mIntent.setDataAndType(fileLoc, "application/vnd.android.package-archive")
            mIntent.flags =
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            mContext.startActivity(mIntent)
        }
    }
}

