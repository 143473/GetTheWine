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
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", producer=" + producer +
                '}';
    }
}
