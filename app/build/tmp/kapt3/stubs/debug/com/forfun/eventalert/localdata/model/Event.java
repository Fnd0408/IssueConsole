package com.forfun.eventalert.localdata.model;

import java.lang.System;

@androidx.room.Entity(tableName = "LocalEvent")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u0006*"}, d2 = {"Lcom/forfun/eventalert/localdata/model/Event;", "", "()V", "EVENT_CONTENT", "", "getEVENT_CONTENT", "()Ljava/lang/String;", "setEVENT_CONTENT", "(Ljava/lang/String;)V", "EVENT_CREATEDATE", "getEVENT_CREATEDATE", "setEVENT_CREATEDATE", "EVENT_CREATOR", "getEVENT_CREATOR", "setEVENT_CREATOR", "EVENT_LEVEL", "", "getEVENT_LEVEL", "()I", "setEVENT_LEVEL", "(I)V", "EVENT_TITLE", "getEVENT_TITLE", "setEVENT_TITLE", "Event_ID", "getEvent_ID", "setEvent_ID", "PROCESSING_PEOPLE_DEPT", "getPROCESSING_PEOPLE_DEPT", "setPROCESSING_PEOPLE_DEPT", "PROCESSING_PEOPLE_ID", "getPROCESSING_PEOPLE_ID", "setPROCESSING_PEOPLE_ID", "PROCESSING_PEOPLE_NAME", "getPROCESSING_PEOPLE_NAME", "setPROCESSING_PEOPLE_NAME", "PROCESSING_TYPE", "", "getPROCESSING_TYPE", "()B", "setPROCESSING_TYPE", "(B)V", "app_debug"})
public final class Event {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int Event_ID;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String EVENT_CONTENT;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String EVENT_CREATEDATE;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String EVENT_CREATOR;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String EVENT_TITLE;
    private int EVENT_LEVEL;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String PROCESSING_PEOPLE_DEPT;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String PROCESSING_PEOPLE_ID;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String PROCESSING_PEOPLE_NAME;
    private byte PROCESSING_TYPE;
    
    public final int getEvent_ID() {
        return 0;
    }
    
    public final void setEvent_ID(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CONTENT() {
        return null;
    }
    
    public final void setEVENT_CONTENT(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CREATEDATE() {
        return null;
    }
    
    public final void setEVENT_CREATEDATE(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CREATOR() {
        return null;
    }
    
    public final void setEVENT_CREATOR(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_TITLE() {
        return null;
    }
    
    public final void setEVENT_TITLE(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getEVENT_LEVEL() {
        return 0;
    }
    
    public final void setEVENT_LEVEL(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_DEPT() {
        return null;
    }
    
    public final void setPROCESSING_PEOPLE_DEPT(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_ID() {
        return null;
    }
    
    public final void setPROCESSING_PEOPLE_ID(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_NAME() {
        return null;
    }
    
    public final void setPROCESSING_PEOPLE_NAME(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final byte getPROCESSING_TYPE() {
        return 0;
    }
    
    public final void setPROCESSING_TYPE(byte p0) {
    }
    
    public Event() {
        super();
    }
}