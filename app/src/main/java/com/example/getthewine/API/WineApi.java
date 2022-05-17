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


    @GET("2743c4dd-3288-44e6-9e69-98818ef1184f")
    //@GET("e098d2d7-6a51-4195-8aac-4e15d4f29956")
    //@GET("f70638bf-bcde-40f3-a595-b10af02705f2")
    //@GET("23f48fe5-41dd-4eb6-8128-e176127cb4df")
    Call<WineResponse> getWineHardCodedById();

    @GET("2951195b-0f09-438c-bd4a-c6af207a2319")
    Call<List<WineResponse>> getSearchedWineListCoded();

    @GET("9a837de7-26c0-4092-87bb-18aea5500850")
    Call<MealResponse> getMealsForTheWine();
}
