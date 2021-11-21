package com.forfun.IssueConsole.functions;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Prefs {
    private static String MainTask = "MainTask";

    public static String GetMain(Context cc, String key) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getString(key, "");
    }

    public static Boolean GetMainBoolean(Context cc, String key) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }

    public static int GetMainInt(Context cc, String key) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getInt(key, 0);
    }

    public static long GetMainLong(Context cc, String key) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getInt(key, 5000);
    }

    public static void SetMain(Context cc, String key, String value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putString(key, value).apply();
    }

    public static void SetMainBoolean(Context cc, String key, Boolean value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putBoolean(key, value).apply();
    }

    public static void SetMainLong(Context cc, String key, int value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putLong(key, value).apply();
    }

    public static void SetMainInt(Context cc, String key, int value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putInt(key, value).apply();
    }

    public static String GetUrl(Context cc) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getString("url", "");
    }

    public static void SetUrl(Context cc, String value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putString("url", value).apply();
    }

    public static Boolean GetTestUrl(Context cc) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        return pref.getBoolean("test_url", false);
    }

    public static void SetTestUrl(Context cc, Boolean value) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().putBoolean("test_url", value).apply();
    }

    public static void cleanData(Context cc) {
        SharedPreferences pref = cc.getSharedPreferences(MainTask, MODE_PRIVATE);
        pref.edit().clear().apply();
    }
}
