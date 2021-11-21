package com.forfun.IssueConsole.models.webapiModels;

import com.google.gson.annotations.SerializedName;

public class VersionCheckRequest {
    @SerializedName("AppId")
    private String AppID;
    @SerializedName("AppVersion")
    private String AppVersion;

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        this.AppID = appID;
    }

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }
}
