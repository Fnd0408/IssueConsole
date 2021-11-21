package com.forfun.IssueConsole.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.forfun.IssueConsole.R
import com.forfun.IssueConsole.functions.Prefs

class InitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
        supportActionBar?.hide()
        //初始連線位置
        if (Prefs.GetTestUrl(this))
            Prefs.SetUrl(this, resources.getString(R.string.test_out_url))
        else
            Prefs.SetUrl(this, resources.getString(R.string.prod_out_url))
    }

    override fun onResume() {
        super.onResume()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                0
            )
            //startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } else {
            var version = "20180801"
            try {
                val pInfo = this.packageManager.getPackageInfo(packageName, 0)
                version = pInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}
