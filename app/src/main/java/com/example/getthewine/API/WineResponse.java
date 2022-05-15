package com.example.getthewine.API;

import com.example.getthewine.Models.Producer;
import com.example.getthewine.Models.Wine;

public class WineResponse {
    private int id;
    private String name;
    private String color;

    private Producer producer;



    public Wine getWine(){
        return new Wine(id, name, color, producer);
    }
}
