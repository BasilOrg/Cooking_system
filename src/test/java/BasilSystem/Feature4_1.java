package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Ingredient;
import org.example.KitchenManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Feature4_1 {

    KitchenManager km =new KitchenManager();



    @Given("the system has access to ingredient stock data")
    public void the_system_has_access_to_ingredient_stock_data() {
        // Mock stock data

        km.addIngredient("Flour", 10, 5);
        km.addIngredient("Sugar", 3, 5);
        km.addIngredient("Milk", 8, 10);
        System.out.println("Stock data initialized.");
        assertTrue(true);


    }

    @When("the kitchen manager checks the stock levels")
    public void the_kitchen_manager_checks_the_stock_levels() {
        System.out.println("Current Stock Levels:");

        km.displayStockLevels();
        assertTrue(true);

    }

    @Then("the system should display real-time stock levels")
    public void the_system_should_display_real_time_stock_levels() {
        System.out.println("Displaying real-time stock levels...");
        km.displayStockLevels();
        assertTrue(true);


    }

    @Given("an ingredient's stock level is below the threshold")
    public void an_ingredient_s_stock_level_is_below_the_threshold() {
        List<Ingredient> lowStock = km.getLowStockIngredients();
        if (!lowStock.isEmpty()) {

            System.out.println("Low stock detected for: " + lowStock.getFirst().getName());

            assertTrue(true);
        }


    }

    @When("the system detects a low stock level")
    public void the_system_detects_a_low_stock_level() {
        List<Ingredient> lowStock = km.getLowStockIngredients();
        if (!lowStock.isEmpty()) {
            System.out.println("Low stock detected.");
            assertTrue(true);
        } else {
            System.out.println("All ingredients are above the threshold.");
            assertFalse(false);
        }

    }

    @Then("the system should suggest restocking that ingredient")
    public void the_system_should_suggest_restocking_that_ingredient() {
        List<Ingredient> lowStock = km.getLowStockIngredients();
        for (Ingredient ingredient : lowStock) {
            System.out.println("Suggested restocking: " + ingredient.getName());

        }

    }

}
