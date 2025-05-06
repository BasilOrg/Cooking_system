package org.example;

public class PurchaseOrder {

    private Ingredient ingredient;
    private int quantity;
    private double price;

    public PurchaseOrder(Ingredient ingredient, int quantity, double price) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.price = price;
    }

    public Ingredient getIngredient() { return ingredient; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
