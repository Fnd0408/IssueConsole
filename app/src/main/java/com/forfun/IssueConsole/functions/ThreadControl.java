package com.forfun.IssueConsole.functions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import com.forfun.IssueConsole.R;
import com.forfun.IssueConsole.activities.LoginActivity;

public class ThreadControl {
    public static void Logout(Context cc) {
        new AlertDialog.Builder(cc)
                .setMessage(R.string.auth_error)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, (dialog, id) -> {
                    Intent intent = new Intent(cc, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    cc.startActivity(intent);
                })
                .show();
    }
}
