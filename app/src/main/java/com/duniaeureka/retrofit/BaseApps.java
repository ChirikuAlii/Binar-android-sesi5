package com.duniaeureka.retrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chirikualii on 03/04/18.
 */

public class BaseApps extends Application {

    public static ApiService service;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        service =  retrofit.create(ApiService.class);
    }
}
