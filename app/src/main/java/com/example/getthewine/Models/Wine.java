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

    public Wine(){

    }


    public Wine(int id, String name, String color, Producer producer) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.producer = producer;
    }

    public Wine(int id, String name, String color, List<String> grapes, Region region, Producer producer, List<String> taste_tags, List<String> event_tags, String price_range, int lifespan, WineTemperature optimal_drinking_temperature, String description) {
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

    public List<String> getGrapes() {
        return grapes;
    }

    public void setGrapes(List<String> grapes) {
        this.grapes = grapes;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<String> getTaste_tags() {
        return taste_tags;
    }

    public void setTaste_tags(List<String> taste_tags) {
        this.taste_tags = taste_tags;
    }

    public List<String> getEvent_tags() {
        return event_tags;
    }

    public void setEvent_tags(List<String> event_tags) {
        this.event_tags = event_tags;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public WineTemperature getOptimal_drinking_temperature() {
        return optimal_drinking_temperature;
    }

    public void setOptimal_drinking_temperature(WineTemperature optimal_drinking_temperature) {
        this.optimal_drinking_temperature = optimal_drinking_temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + description + '\'';
    }
}
