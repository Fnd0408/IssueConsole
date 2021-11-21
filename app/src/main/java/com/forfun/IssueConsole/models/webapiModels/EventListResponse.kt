package com.forfun.IssueConsole.models.webapiModels

data class EventListResponse(
    val code: Int,
    val content: List<EventContent>,
    val msg: String
)