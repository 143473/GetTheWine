package com.example.getthewine.API;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static WineApi wineApi;

    public static WineApi getWineApi(){
        if(wineApi == null){
            wineApi = new Retrofit.Builder()
                    .baseUrl("https://mocki.io/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WineApi.class);
        }
        return wineApi;
    }
}
