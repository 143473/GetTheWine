package com.example.getthewine.Models;

import android.media.Image;

public class WineExtraDetails {
    private String name;
    private Image large_image_url;
    private Image small_image_url;

    public WineExtraDetails(String name, Image large_image_url, Image small_image_url) {
        this.name = name;
        this.large_image_url = large_image_url;
        this.small_image_url = small_image_url;
    }
}
