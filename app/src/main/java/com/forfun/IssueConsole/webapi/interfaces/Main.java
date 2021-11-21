package com.forfun.IssueConsole.webapi.interfaces;

import com.forfun.IssueConsole.models.webapiModels.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

public interface Main {
    //版本檢查(POST)
    @POST("/api/app/ChkVer")
    Call<VersionCheckResponse> getVersion(@Body VersionCheckRequest body);

    //登入(POST)
    @POST("/api/app/login")
    Call<LoginResponse> login(@Body LoginRequest body);

    //登出(DELETE)
    @DELETE("/api/app/logout")
    Call<BaseModel> logout();
}
