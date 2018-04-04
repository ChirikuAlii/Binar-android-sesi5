package com.duniaeureka.retrofit;

import android.app.Application;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chirikualii on 03/04/18.
 */

public class BaseApps extends Application {

    public static ApiService service;



    OkHttpClient httpClient = new OkHttpClient();

    @Override
    public void onCreate() {
        super.onCreate();

        service = getRetrofit().create(ApiService.class);


    }
    //retrofit as Internet exploler
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                //menyambungkan ke okHttpClient
                .client(getHttpClient())
                .build();

    }
    //ok http as chrome
    private OkHttpClient getHttpClient() {

        return  new OkHttpClient.Builder()
                .addInterceptor(getHttpLogInterceptor())
                .build();
    }

    //mengambil logg
    private Interceptor getHttpLogInterceptor() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level;

        if (BuildConfig.DEBUG){
            level = HttpLoggingInterceptor.Level.BODY;
        }else {
            level = HttpLoggingInterceptor.Level.NONE;

        }
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

}
