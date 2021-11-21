package com.forfun.IssueConsole.webapi;

import android.content.Context;
import com.forfun.IssueConsole.R;
import com.forfun.IssueConsole.functions.Prefs;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitBase {
    public static Retrofit outsideConnection(Context mContext) {
        String url;
        if (!Prefs.GetTestUrl(mContext))
            url = mContext.getResources().getString(R.string.prod_out_url);
        else
            url = mContext.getResources().getString(R.string.test_out_url);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES);
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(httpClient.build())
                .build();
    }
}
