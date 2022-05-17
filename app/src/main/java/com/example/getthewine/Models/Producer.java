package com.example.getthewine.Models;

import com.google.gson.annotations.SerializedName;

public class Producer {

    @SerializedName("name")
    private String producerName;
    private Region region;

    public void setRegion(Region region) {
        this.region = region;
    }

    public Producer(String name, Region region) {
        this.producerName = name;
        this.region = region;
    }

    @Override
    public String toString() {
        return
                "name: " + producerName + "\n" +
                "country: " + region;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Region getRegion() {
        return region;
    }
}
