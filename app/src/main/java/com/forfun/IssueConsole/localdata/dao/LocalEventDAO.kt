package com.forfun.IssueConsole.localdata.dao

import androidx.room.*

import com.forfun.IssueConsole.localdata.model.Event

@Dao
interface LocalEventDAO {
    @Query("SELECT * FROM LocalEvent WHERE PROCESSING_TYPE != 3")
    fun getAllEvents(): List<Event?>

    @Query("SELECT * FROM LocalEvent WHERE PROCESSING_TYPE == 3")
    fun getAllFinishedEvents(): List<Event?>

    @Query("SELECT * FROM LocalEvent WHERE Event_ID LIKE :eventID")
    fun getEvent(eventID: String?): Event?

    @Insert
    fun insert(vararg Events: Event?)

    @Update
    fun update(vararg Events: Event?)

    @Delete
    fun delete(vararg Events: Event?)
}