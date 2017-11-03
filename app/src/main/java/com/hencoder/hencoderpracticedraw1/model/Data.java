package com.hencoder.hencoderpracticedraw1.model;

/**
 * Created by pengyang on 17-11-3.
 */

public class Data {

    private String name;
    private int number;
    private int color;

    public Data(String name, int number, int color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
