package com.example.getthewine.UI.Meal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.getthewine.Models.Meal;
import com.example.getthewine.Models.Wine;
import com.example.getthewine.Repo.MealRepository;

import java.util.List;

public class MealsViewModel extends AndroidViewModel {

    private MealRepository mealRepository;


    public MealsViewModel(@NonNull Application application) {
        super(application);
        mealRepository = MealRepository.getInstance(application);
    }

    public void searchForRecommendedMeals() {
        mealRepository.searchRecommendedMealForWine();
    }

    public LiveData<List<Meal>> getRecommendedMeals() {
       return mealRepository.getRecommendedMeals();
    }
}
