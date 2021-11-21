package com.forfun.eventalert.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001aH\u0014J\u0016\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/forfun/eventalert/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "db", "Lcom/forfun/eventalert/localdata/db/EventDatabase;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "<set-?>", "", "isFinished", "()Z", "setFinished", "(Z)V", "isFinished$delegate", "Lkotlin/properties/ReadWriteProperty;", "localEvent", "", "Lcom/forfun/eventalert/localdata/model/Event;", "prefs", "Landroid/content/SharedPreferences;", "viewData", "", "Lcom/forfun/eventalert/models/webapiModels/EventContent;", "getEventList", "", "getHWToken", "getToken", "listenChannel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refreshData", "eventList", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private java.util.List<com.forfun.eventalert.localdata.model.Event> localEvent;
    private final kotlin.properties.ReadWriteProperty isFinished$delegate = null;
    private android.content.SharedPreferences prefs;
    private com.forfun.eventalert.localdata.db.EventDatabase db;
    private java.util.List<com.forfun.eventalert.models.webapiModels.EventContent> viewData;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    private final boolean isFinished() {
        return false;
    }
    
    private final void setFinished(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public final void getEventList() {
    }
    
    private final void refreshData(java.util.List<com.forfun.eventalert.models.webapiModels.EventContent> eventList) {
    }
    
    private final void getToken() {
    }
    
    private final void listenChannel() {
    }
    
    private final void getHWToken() {
    }
    
    public MainActivity() {
        super();
    }
}