package com.forfun.IssueConsole.models.webapiModels


data class EventContent(
    val EVENT_CONTENT: String,
    val EVENT_CREATEDATE: String,
    val EVENT_CREATOR: String,
    val EVENT_TITLE: String,
    val EVENT_ID: String,
    val EVENT_LEVEL: Int,
    val PROCESSING_PEOPLE_DEPT: String,
    val PROCESSING_PEOPLE_ID: String,
    val PROCESSING_PEOPLE_NAME: String,
    val PROCESSING_TYPE: Byte
)