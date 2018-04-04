package com.duniaeureka.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.duniaeureka.retrofit.ApiService;
import com.duniaeureka.retrofit.BaseApps;
import com.duniaeureka.retrofit.R;
import com.duniaeureka.retrofit.adapter.ArtikelAdapter;
import com.duniaeureka.retrofit.model.Artikel;
import com.duniaeureka.retrofit.model.ArtikelResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Artikel> artikelList = new ArrayList<>();
    ArtikelAdapter adapter;
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getArticle();
        initView();

    }

    private void initView() {

        RecyclerView recyclerView = findViewById(R.id.rec_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArtikelAdapter(artikelList);
        recyclerView.setAdapter(adapter);
    }

    private void getArticle(){
        BaseApps.service.getArtikel().enqueue(new Callback<ArtikelResponse>() {
            @Override
            public void onResponse(Call<ArtikelResponse> call, Response<ArtikelResponse> response) {
                //Log.d(TAG, "onResponse:  " + new Gson().toJsonTree(response));
                artikelList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArtikelResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
                t.printStackTrace();
            }
        });



    }
}
