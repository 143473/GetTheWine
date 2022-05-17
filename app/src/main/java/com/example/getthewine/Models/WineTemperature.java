package com.example.getthewine.Models;

public class WineTemperature {
    private float celsius;
    private float fahrenheit;

    public WineTemperature(float celsius, float fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public WineTemperature(){

    }

    @Override
    public String toString() {
        return "Optimal serving temperature" +
                "celsius=" + celsius +
                ", fahrenheit=" + fahrenheit +
                '}';
    }

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(float fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
