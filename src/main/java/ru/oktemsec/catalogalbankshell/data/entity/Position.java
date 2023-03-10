package ru.oktemsec.catalogalbankshell.data.entity;

public class Position {
    private int instanceCount = 0;
    private final int id;
    private String name;
    private float price;
    private int count;
    private final String unit; //единица измерения

    public static final String currency = "руб/ед.";

    //Constructor
    public Position(Category category, String name, float price, int count, String unit) {
        id = category.getPositiond();
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.count = count;
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
