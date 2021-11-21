package com.forfun.IssueConsole.webapi.interfaces;

import com.forfun.IssueConsole.models.webapiModels.BaseModel;
import com.forfun.IssueConsole.models.webapiModels.ChangeProcessRequest;
import com.forfun.IssueConsole.models.webapiModels.EventListResponse;
import com.forfun.IssueConsole.models.webapiModels.FilterModel;
import com.forfun.IssueConsole.models.webapiModels.SaveTokenRequest;

import retrofit2.Call;
import retrofit2.http.*;

public interface Event {
    //版本檢查(POST)
    @POST("/api/oa/ea/changeProcessingStatus")
    Call<BaseModel> changeProcessingStatus(@Header("Authorization") String auth, @Body ChangeProcessRequest body);

    //取得事件列表(POST)
    @POST("/api/oa/ea/getEventList")
    Call<EventListResponse> getEventList(@Header("Authorization") String auth, @Body FilterModel body);

    //回傳FCM Token(POST)
    @POST("/api/oa/ea/saveAndroidDevice")
    Call<BaseModel> saveAndroidToken(@Header("Authorization") String auth, @Body SaveTokenRequest body);
}
