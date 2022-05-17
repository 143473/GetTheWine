package com.example.getthewine.API;

import com.example.getthewine.Models.Producer;
import com.example.getthewine.Models.Region;
import com.example.getthewine.Models.Wine;
import com.example.getthewine.Models.WineTemperature;

import java.util.List;

public class WineResponse {
    private int id;
    private String name;
    private String color;
    private List<String> grapes;
    private Region region;
    private Producer producer;
    private List<String> taste_tags;
    private List<String> event_tags;
    private String price_range;
    private int lifespan;
    private WineTemperature optimal_drinking_temperature;
    private String description;



    public Wine getWine(){
        return new Wine(id, name, color, producer);
    }

    public Wine getDetailedWine(){
        return new Wine(id, name,  color, grapes,  region,  producer,  taste_tags,  event_tags,  price_range, lifespan, optimal_drinking_temperature, description);
    }
}
