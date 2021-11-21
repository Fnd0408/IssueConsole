package com.forfun.eventalert.localdata.db;

import java.lang.System;

@androidx.room.Database(entities = {com.forfun.eventalert.localdata.model.Event.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/forfun/eventalert/localdata/db/EventDatabase;", "Landroidx/room/RoomDatabase;", "()V", "eventDao", "Lcom/forfun/eventalert/localdata/dao/LocalEventDAO;", "getEventDao", "()Lcom/forfun/eventalert/localdata/dao/LocalEventDAO;", "clearAllTables", "", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "createOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "config", "Landroidx/room/DatabaseConfiguration;", "Companion", "app_debug"})
public abstract class EventDatabase extends androidx.room.RoomDatabase {
    private static final java.lang.String DB_NAME = "EventDatabase.db";
    private static volatile com.forfun.eventalert.localdata.db.EventDatabase instance;
    public static final com.forfun.eventalert.localdata.db.EventDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.forfun.eventalert.localdata.dao.LocalEventDAO getEventDao();
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.sqlite.db.SupportSQLiteOpenHelper createOpenHelper(@org.jetbrains.annotations.NotNull()
    androidx.room.DatabaseConfiguration config) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.room.InvalidationTracker createInvalidationTracker() {
        return null;
    }
    
    @java.lang.Override()
    public void clearAllTables() {
    }
    
    public EventDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/forfun/eventalert/localdata/db/EventDatabase$Companion;", "", "()V", "DB_NAME", "", "instance", "Lcom/forfun/eventalert/localdata/db/EventDatabase;", "create", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final synchronized com.forfun.eventalert.localdata.db.EventDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.forfun.eventalert.localdata.db.EventDatabase create(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}