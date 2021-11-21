package com.forfun.IssueConsole.models.webapiModels

data class FilterModel(
    val days: Int = -6,
    val isDone: Boolean = false,
    val count: Int = 10,
    val level: Int = 0
)