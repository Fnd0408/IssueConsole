package com.forfun.eventalert.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/forfun/eventalert/services/FCMService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "Tag", "", "handleNow", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "p0", "scheduleJob", "app_debug"})
public final class FCMService extends com.google.firebase.messaging.FirebaseMessagingService {
    private final java.lang.String Tag = "FCM";
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    private final void handleNow() {
    }
    
    private final void scheduleJob() {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public FCMService() {
        super();
    }
}