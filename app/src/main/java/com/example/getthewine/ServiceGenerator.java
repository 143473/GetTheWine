package com.example.getthewine;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static WineApi wineApi;

    public static WineApi getWineApi(){
        if(wineApi == null){
            wineApi = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WineApi.class);
        }
        return wineApi;
    }
}
