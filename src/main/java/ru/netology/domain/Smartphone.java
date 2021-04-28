package ru.netology.domain;

public class Smartphone extends Product{
    private String model;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String model) {
        super(id, name, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

}
