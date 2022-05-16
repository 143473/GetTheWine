package com.example.getthewine.Repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.getthewine.API.ServiceGenerator;
import com.example.getthewine.API.WineApi;
import com.example.getthewine.API.WineResponse;
import com.example.getthewine.Models.Wine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class WineRepository {

    private static WineRepository instance;
    private final MutableLiveData<Wine> searchedWine;
    private final MutableLiveData<List<Wine>> searchedWineList;

    private WineRepository() {
        searchedWine = new MutableLiveData<>();
        searchedWineList = new MutableLiveData<>();
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

    public LiveData<List<Wine>> getSearchedWineList(){
        return searchedWineList;
    }

    public void searchForWine() {
        WineApi wineApi = ServiceGenerator.getWineApi();
        Call<WineResponse> call = wineApi.getWineHardCodedById();
        call.enqueue(new Callback<WineResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<WineResponse> call, Response<WineResponse> response) {
                if (response.isSuccessful() && response.body()!= null) {
                    searchedWine.setValue(response.body().getDetailedWine());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<WineResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void searchForWineList() {
        WineApi wineApi = ServiceGenerator.getWineApi();
        Call<List<WineResponse>> call = wineApi.getSearchedWineListCoded();
        call.enqueue(new Callback<List<WineResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<WineResponse>> call, Response<List<WineResponse>> response) {
                if (response.isSuccessful() && response.body()!= null) {
                    List<Wine> wineList = new ArrayList<>();
                        for (int i = 0; i < response.body().size(); i++) {
                            wineList.add(response.body().get(i).getWine());
                        }
                        searchedWineList.setValue(wineList);
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<WineResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
