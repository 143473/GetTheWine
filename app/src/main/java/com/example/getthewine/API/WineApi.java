package com.example.getthewine.API;

import com.example.getthewine.API.WineResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WineApi {

    @GET("wines")
    Call<WineResponse> getWine(@Query("language") String language,
                               @Query("per-page") int perPage,
                               @Query("page") int page,
                               @Query("search") String search);


    @GET("api/wine/{id}")
    Call<WineResponse> getWineById(@Path("id") int id, @Query("language") String language);


    @GET("26f47bca-e93a-4e9a-b7c5-147d50e6d4ca")
    Call<WineResponse> getWineHardCodedById();

    @GET("2951195b-0f09-438c-bd4a-c6af207a2319")
    Call<List<WineResponse>> getSearchedWineListCoded();
}
