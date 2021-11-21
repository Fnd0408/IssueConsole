package com.forfun.eventalert.models.webapiModels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003Jm\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\tH\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2 = {"Lcom/forfun/eventalert/models/webapiModels/EventContent;", "", "EVENT_CONTENT", "", "EVENT_CREATEDATE", "EVENT_CREATOR", "EVENT_TITLE", "EVENT_ID", "EVENT_LEVEL", "", "PROCESSING_PEOPLE_DEPT", "PROCESSING_PEOPLE_ID", "PROCESSING_PEOPLE_NAME", "PROCESSING_TYPE", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V", "getEVENT_CONTENT", "()Ljava/lang/String;", "getEVENT_CREATEDATE", "getEVENT_CREATOR", "getEVENT_ID", "getEVENT_LEVEL", "()I", "getEVENT_TITLE", "getPROCESSING_PEOPLE_DEPT", "getPROCESSING_PEOPLE_ID", "getPROCESSING_PEOPLE_NAME", "getPROCESSING_TYPE", "()B", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class EventContent {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String EVENT_CONTENT = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String EVENT_CREATEDATE = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String EVENT_CREATOR = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String EVENT_TITLE = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String EVENT_ID = null;
    private final int EVENT_LEVEL = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PROCESSING_PEOPLE_DEPT = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PROCESSING_PEOPLE_ID = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String PROCESSING_PEOPLE_NAME = null;
    private final byte PROCESSING_TYPE = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CONTENT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CREATEDATE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_CREATOR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_TITLE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEVENT_ID() {
        return null;
    }
    
    public final int getEVENT_LEVEL() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_DEPT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPROCESSING_PEOPLE_NAME() {
        return null;
    }
    
    public final byte getPROCESSING_TYPE() {
        return 0;
    }
    
    public EventContent(@org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CONTENT, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CREATEDATE, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CREATOR, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_TITLE, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_ID, int EVENT_LEVEL, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_DEPT, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_ID, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_NAME, byte PROCESSING_TYPE) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    public final byte component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.forfun.eventalert.models.webapiModels.EventContent copy(@org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CONTENT, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CREATEDATE, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_CREATOR, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_TITLE, @org.jetbrains.annotations.NotNull()
    java.lang.String EVENT_ID, int EVENT_LEVEL, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_DEPT, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_ID, @org.jetbrains.annotations.NotNull()
    java.lang.String PROCESSING_PEOPLE_NAME, byte PROCESSING_TYPE) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}