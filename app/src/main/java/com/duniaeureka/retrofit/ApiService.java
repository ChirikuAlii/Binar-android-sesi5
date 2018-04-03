package com.duniaeureka.retrofit;

import com.duniaeureka.retrofit.model.ArtikelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chirikualii on 03/04/18.
 */

public interface ApiService {
    @GET("v2/top-headlines?country=us&apiKey=452a8b968c514facb39fd8fff27381bb")
    Call<ArtikelResponse> getArtikel();
}
