package com.forfun.IssueConsole.localdata.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocalEvent")
class Event {
    @PrimaryKey(autoGenerate = true)
    var Event_ID = 0
    var EVENT_CONTENT: String =""
    var EVENT_CREATEDATE: String =""
    var EVENT_CREATOR: String =""
    var EVENT_TITLE: String =""
    var EVENT_LEVEL: Int =1
    var PROCESSING_PEOPLE_DEPT: String =""
    var PROCESSING_PEOPLE_ID: String =""
    var PROCESSING_PEOPLE_NAME: String =""
    var PROCESSING_TYPE: Byte =1
}