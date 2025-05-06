package org.example;

public class Ingredient {
    private String name;
    private int currentStock;
    private int threshold;



    public Ingredient(String name, int currentStock, int threshold) {
        this.name = name;
        this.currentStock = currentStock;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getThreshold() {
        return threshold;
    }

    public boolean isLowStock() {
        return currentStock < threshold;
}
}