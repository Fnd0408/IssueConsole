package com.forfun.IssueConsole.functions;

import android.content.Context;

public class Feedback {
    public static void ApiError(Context cc, String msg) {
        ShowAlert.TipMsg(cc, "API", msg);
    }

    public static void AppError(Context cc, String msg) {
        ShowAlert.TipMsg(cc, "APP", msg);
    }
}
