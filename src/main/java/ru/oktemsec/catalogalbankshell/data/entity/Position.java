package ru.oktemsec.catalogalbankshell.data.entity;

public class Position {
    private int id;
    private String name;
    private float price;
    private int count;
    private String unit; //единица измерения

    //Constructor


    public Position(String name, float price, int count, String unit) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.unit = unit;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }
}
