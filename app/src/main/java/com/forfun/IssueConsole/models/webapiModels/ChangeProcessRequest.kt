package com.forfun.IssueConsole.models.webapiModels

data class ChangeProcessRequest(
    var EventId: String,
    val ProcessingPeopleId: String,
    val ProcessingPeopleName: String,
    val ProcessingPeopleDept: String,
    val ProcessingType: Int
)