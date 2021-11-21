package com.forfun.IssueConsole.models.webapiModels


data class SaveTokenRequest(
    val USER_ID: String,
    val UPDATE_TIME: String,
    val ANDROID_TOKEN: String,
    val IOS_TOKEN: String,
    val WEB_TOKEN: String,
    val OS_TOKEN: String
)
