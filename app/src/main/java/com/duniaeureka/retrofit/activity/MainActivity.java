package com.duniaeureka.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.duniaeureka.retrofit.ApiService;
import com.duniaeureka.retrofit.BaseApps;
import com.duniaeureka.retrofit.R;
import com.duniaeureka.retrofit.model.ArtikelResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getArticle();


    }
    private void getArticle(){
        BaseApps.service.getArtikel().enqueue(new Callback<ArtikelResponse>() {
            @Override
            public void onResponse(Call<ArtikelResponse> call, Response<ArtikelResponse> response) {
                Log.d(TAG, "onResponse:  " + new Gson().toJsonTree(response));
            }

            @Override
            public void onFailure(Call<ArtikelResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
                t.printStackTrace();
            }
        });



    }
}
