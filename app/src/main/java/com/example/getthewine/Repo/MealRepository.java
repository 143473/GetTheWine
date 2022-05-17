package com.example.getthewine.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.getthewine.API.MealResponse;
import com.example.getthewine.API.ServiceGenerator;
import com.example.getthewine.API.WineApi;
import com.example.getthewine.API.WineResponse;
import com.example.getthewine.Models.Meal;
import com.example.getthewine.Models.Wine;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MealRepository {

    private final MutableLiveData<List<Meal>> recommendedMeals;
    private static MealRepository instance;
    private Application application;

    private MealRepository(Application application){
        this.application = application;
        recommendedMeals = new MutableLiveData<>();
    }

    public static synchronized MealRepository getInstance(Application application) {
        if (instance == null) {
            instance = new MealRepository(application);
        }
        return instance;
    }

    public LiveData<List<Meal>> getRecommendedMeals() {
        return recommendedMeals;
    }

    public void searchRecommendedMealForWine() {
        WineApi wineApi = ServiceGenerator.getWineApi();
        Call<List<MealResponse>> call = wineApi.getMealsForTheWine();
        call.enqueue(new Callback<List<MealResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MealResponse>> call, Response<List<MealResponse>> response) {
                if (response.isSuccessful() && response.body()!= null) {
                    List<Meal> mealList = new ArrayList<>();
                    for (int i = 0; i < response.body().size(); i++) {
                        mealList.add(response.body().get(i).getMeal());
                    }
                    recommendedMeals.setValue(mealList);
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MealResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
