package com.example.getthewine.Models;

import com.google.gson.annotations.SerializedName;

public class Region {

    @SerializedName("Country")
    private String country;

    @SerializedName("Region")
    private String region;

    public Region(String country, String region) {
        this.country = country;
        this.region = region;
    }

    @Override
    public String toString() {
        return country + ", " + region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
