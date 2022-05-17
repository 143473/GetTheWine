package com.example.getthewine.UI.Meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getthewine.R;
import com.example.getthewine.UI.Wine.WineViewModel;

public class RecommendedMealsFragment extends Fragment {

    private MealsViewModel mealsViewModel;
    private View rootView = null;

    private RecyclerView recyclerView;

    public RecommendedMealsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealsViewModel = new ViewModelProvider(this).get(MealsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.recommended_meals, container, false);
        recyclerView = rootView.findViewById(R.id.recommendedMealsRecyclerView);

        MealsRecyclerViewAdapter recyclerViewAdapter = new MealsRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        mealsViewModel.getRecommendedMeals().observe(getViewLifecycleOwner(), meals -> {
            recyclerViewAdapter.setMealList(meals);
        });

        return rootView;
    }
}
