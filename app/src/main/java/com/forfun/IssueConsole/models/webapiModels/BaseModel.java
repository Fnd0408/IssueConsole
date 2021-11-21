package com.forfun.IssueConsole.models.webapiModels;

import com.google.gson.annotations.SerializedName;

public class BaseModel {

    /**
     * code : 200
     * msg : 上傳成功
     */
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
