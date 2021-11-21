package com.forfun.eventalert.webapi.callback;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/forfun/eventalert/webapi/callback/CheckVersionCallback;", "Lretrofit2/Callback;", "Lcom/forfun/eventalert/models/webapiModels/VersionCheckResponse;", "mContext", "Lcom/forfun/eventalert/activities/InitActivity;", "(Lcom/forfun/eventalert/activities/InitActivity;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "onComplete", "Landroid/content/BroadcastReceiver;", "deleteAPK", "", "downloadAPK", "url", "", "onFailure", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "showVersionAlert", "version", "isForced", "", "versionMsg", "app_debug"})
public final class CheckVersionCallback implements retrofit2.Callback<com.forfun.eventalert.models.webapiModels.VersionCheckResponse> {
    @org.jetbrains.annotations.NotNull()
    public java.io.File file;
    private final android.content.BroadcastReceiver onComplete = null;
    private com.forfun.eventalert.activities.InitActivity mContext;
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @java.lang.Override()
    public void onResponse(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.forfun.eventalert.models.webapiModels.VersionCheckResponse> call, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.forfun.eventalert.models.webapiModels.VersionCheckResponse> response) {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.forfun.eventalert.models.webapiModels.VersionCheckResponse> call, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    private final void showVersionAlert(java.lang.String version, java.lang.String url, boolean isForced, java.lang.String versionMsg) {
    }
    
    private final void downloadAPK(java.lang.String url) {
    }
    
    private final void deleteAPK() {
    }
    
    public CheckVersionCallback(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.activities.InitActivity mContext) {
        super();
    }
}