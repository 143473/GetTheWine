package com.example.getthewine.Models;

public class Meal {
    private int id;
    private String name;
    private String remarks;
    private int score;

    public Meal(int id, String name, String remarks, int score) {
        this.id = id;
        this.name = name;
        this.remarks = remarks;
        this.score = score;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
