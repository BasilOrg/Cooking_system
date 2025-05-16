package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KitchenManager {

    private final  ArrayList<Chef> chefRegistry= new ArrayList<>();
    private final ArrayList<Task> pendingTasks = new ArrayList<>();
    private Map<String, Ingredient> ingredients = new HashMap<>();


    public void storeChef(Chef chef) {

        chefRegistry.add(chef);
        System.out.println(chef);
    }
    /*
    public void addTask(String taskName, String requiredSpecialization) {
        Task task = new Task();
        pendingTasks.add(task);
    }
*/
    public void addIngredient(String name, int initialStock, int threshold) {
        ingredients.put(name, new Ingredient(name, initialStock, threshold));
    }
    /*
    public void updateStock(String name, int amount) {
        Ingredient ingredient = ingredients.get(name);
        if (ingredient != null) {
            ingredient.setCurrentStock(ingredient.getCurrentStock() + amount);
        }
    }
*/

    public List<Ingredient> getLowStockIngredients() {
        List<Ingredient> lowStock = new ArrayList<>();
        for (Ingredient ingredient : ingredients.values()) {
            if (ingredient.isLowStock()) {
                lowStock.add(ingredient);
            }
        }
        return lowStock;
    }

    public void displayStockLevels() {
        System.out.println("Current Stock Levels:");
        ingredients.forEach((name, ingredient) ->
                        System.out.println(name + ": " + ingredient.getCurrentStock())
                );
}



}


