package com.example.getthewine;

public class WineResponse {
    private int id;
    private String name;

    public Wine getWine(){
        return new Wine(id, name);
    }

}
