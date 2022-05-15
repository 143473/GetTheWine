package com.example.getthewine.API;

import com.example.getthewine.API.WineResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WineApi {
    String API_KEY = "13bLFexia6hoJe7N6ySMKD3jUYqsNeAQxxp94irB";

    @GET("wines")
    Call<WineResponse> getWine(@Query("language") String language,
                               @Query("per-page") int perPage,
                               @Query("page") int page,
                               @Query("search") String search);

    @GET("c54fb759-df68-4e59-b18c-dcae616eb52a")
    Call<WineResponse> getWineHardCoded();

    @GET("80bb0a81-29d7-4606-867b-11d1ebd2dcad")
    Call<List<WineResponse>> getSearchedWineListCoded();

    @GET("api/wine/{id}")
    Call<WineResponse> getWineById(@Path("id") int id, @Query("language") String language);

}
