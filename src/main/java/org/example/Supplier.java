package org.example;

public class Supplier {

    private String name;
    private double price;

    public Supplier(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPriceFor(Ingredient ingredient) {
        return price;
    }

    public  String getName(){
        return name;
    }
}
