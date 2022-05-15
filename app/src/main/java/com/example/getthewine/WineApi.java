package com.example.getthewine;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WineApi {

    @GET("{name}")
    Call<WineResponse> getWine(@Path("name") String name);
}
