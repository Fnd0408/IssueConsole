package com.forfun.eventalert.webapi.callback;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/forfun/eventalert/webapi/callback/LoginCallback;", "Lretrofit2/Callback;", "Lcom/forfun/eventalert/models/webapiModels/LoginResponse;", "mContext", "Lcom/forfun/eventalert/activities/LoginActivity;", "isAuto", "", "(Lcom/forfun/eventalert/activities/LoginActivity;Z)V", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "app_debug"})
public final class LoginCallback implements retrofit2.Callback<com.forfun.eventalert.models.webapiModels.LoginResponse> {
    private com.forfun.eventalert.activities.LoginActivity mContext;
    private boolean isAuto;
    
    @java.lang.Override()
    public void onResponse(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.forfun.eventalert.models.webapiModels.LoginResponse> call, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.forfun.eventalert.models.webapiModels.LoginResponse> response) {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.forfun.eventalert.models.webapiModels.LoginResponse> call, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    public LoginCallback(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.activities.LoginActivity mContext, boolean isAuto) {
        super();
    }
}