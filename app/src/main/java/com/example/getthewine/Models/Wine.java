package com.example.getthewine.Models;

public class Wine {
    private int id;
    private String name;
    private String color;
    private Producer producer;

    public Wine(int id, String name, String color, Producer producer) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", producer=" + producer +
                '}';
    }
}
