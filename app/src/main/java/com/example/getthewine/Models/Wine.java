package com.example.getthewine.Models;

import java.util.List;

public class Wine {
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
    private WineExtraDetails glass_type;


    public Wine(int id, String name, String color, Producer producer) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.producer = producer;
    }

    public Wine(int id, String name, String color, List<String> grapes, Region region, Producer producer, List<String> taste_tags, List<String> event_tags, String price_range, int lifespan, WineTemperature optimal_drinking_temperature, String description, WineExtraDetails glass_type) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.grapes = grapes;
        this.region = region;
        this.producer = producer;
        this.taste_tags = taste_tags;
        this.event_tags = event_tags;
        this.price_range = price_range;
        this.lifespan = lifespan;
        this.optimal_drinking_temperature = optimal_drinking_temperature;
        this.description = description;
        this.glass_type = glass_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Wine{" +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", grapes=" + grapes +
                ", region=" + region +
                ", producer=" + producer +
                ", taste_tags=" + taste_tags +
                ", event_tags=" + event_tags +
                ", price_range='" + price_range + '\'' +
                ", lifespan=" + lifespan +
                ", optimal_drinking_temperature=" + optimal_drinking_temperature +
                ", description='" + description + '\'' +
                ", glass_type=" + glass_type +
                '}';
    }
}
