package com.example.getthewine.Repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.getthewine.API.ServiceGenerator;
import com.example.getthewine.API.WineApi;
import com.example.getthewine.API.WineResponse;
import com.example.getthewine.Models.Wine;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WineRepository {

    private static WineRepository instance;
    private final MutableLiveData<Wine> searchedWine;

    private WineRepository() {
        searchedWine = new MutableLiveData<>();
    }

    public static synchronized WineRepository getInstance() {
        if (instance == null) {
            instance = new WineRepository();
        }
        return instance;
    }

    public LiveData<Wine> getSearchedWine() {
        return searchedWine;
    }


    public void searchForWine() {
        WineApi wineApi = ServiceGenerator.getWineApi();
//        Call<WineResponse> call = wineApi.getWineById(id, language);
//        Call<WineResponse> call = wineApi.getWine(wineName, perPage, page, search);
        Call<WineResponse> call = wineApi.getWineHardCoded();
        call.enqueue(new Callback<WineResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<WineResponse> call, Response<WineResponse> response) {
                if (response.isSuccessful()) {
                    searchedWine.setValue(response.body().getWine());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<WineResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });

    }
}
