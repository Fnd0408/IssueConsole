package com.forfun.IssueConsole.models.webapiModels;

public class LoginRequest {

    /**
     * id : 1
     * pwd : 19910101
     * domain : forfun
     * appId : 1
     */

    private String id;
    private String pwd;
    private String domain;
    private String appId = "3";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAppId() {
        return "3";
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

