package com.example.getthewine.API;

import com.example.getthewine.Models.Meal;

public class MealResponse {
    private int id;
    private String name;
    private String remarks;
    private int score;

    public Meal getMeal(){
        return new Meal(id, name, remarks, score);
    }
}
