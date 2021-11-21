package com.forfun.IssueConsole.functions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;

import com.forfun.IssueConsole.R;

public class ShowAlert {
    private static ProgressDialog dialog;
    private static String[] ignoreArray = {"ignoreClass"};

    public static void TipMsg(Context cc, String msg) {
        new AlertDialog.Builder(cc)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, (dialog, id) -> {

                    for (String item : ignoreArray) {
                        if (cc.getClass().getName().contains(item)) {
                            dialog.dismiss();
                            ((Activity) cc).finish();
                        }
                    }
                })
                .show();
    }

    public static void TipMsg(Context cc, String msg, AlertDialog.OnClickListener clickListener) {
        new AlertDialog.Builder(cc)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, clickListener)
                .setNegativeButton(R.string.cancel, (dialog, id) -> dialog.dismiss())
                .show();
    }

    public static void TipMsg(Context cc, String title, String msg) {
        new AlertDialog.Builder(cc)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, (dialog, id) -> {
                    for (String item : ignoreArray) {
                        if (cc.getClass().getName().contains(item)) {
                            dialog.dismiss();
                            ((Activity) cc).finish();
                        }
                    }
                })
                .show();
    }

    public static void InitProcess(Context cc) {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
        dialog = new ProgressDialog(cc);
        dialog.setCancelable(false);
        dialog.setMessage(cc.getString(R.string.connecting_msg));
//        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, cc.getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
        View view = dialog.getLayoutInflater().inflate(R.layout.loading_title, null);
        dialog.setCustomTitle(view);
    }

    public static void InitWritingProcess(Context cc) {
        dialog = new ProgressDialog(cc);
        dialog.setCancelable(false);
        dialog.setMessage(cc.getString(R.string.writing_data));
        View view = dialog.getLayoutInflater().inflate(R.layout.loading_title, null);
        dialog.setCustomTitle(view);
    }

    public static void Loading(boolean status) {
        if (status)
            dialog.show();
        else
            dialog.dismiss();
    }
}
