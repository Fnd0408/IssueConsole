package com.forfun.eventalert.localdata.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\'\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\'J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\'J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\'J%\u0010\u000e\u001a\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\'\u00a2\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\'\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/forfun/eventalert/localdata/dao/LocalEventDAO;", "", "delete", "", "Events", "", "Lcom/forfun/eventalert/localdata/model/Event;", "([Lcom/forfun/eventalert/localdata/model/Event;)V", "getAllEvents", "", "getAllFinishedEvents", "getEvent", "eventID", "", "insert", "update", "app_debug"})
public abstract interface LocalEventDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM LocalEvent WHERE PROCESSING_TYPE != 3")
    public abstract java.util.List<com.forfun.eventalert.localdata.model.Event> getAllEvents();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM LocalEvent WHERE PROCESSING_TYPE == 3")
    public abstract java.util.List<com.forfun.eventalert.localdata.model.Event> getAllFinishedEvents();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM LocalEvent WHERE Event_ID LIKE :eventID")
    public abstract com.forfun.eventalert.localdata.model.Event getEvent(@org.jetbrains.annotations.Nullable()
    java.lang.String eventID);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.localdata.model.Event... Events);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.localdata.model.Event... Events);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.localdata.model.Event... Events);
}