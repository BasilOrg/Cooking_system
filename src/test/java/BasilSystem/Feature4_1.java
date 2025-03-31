package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class Feature4_1 {

    private final Map<String, Integer> stockLevels = new HashMap<>();
    private final int THRESHOLD = 5;
    private boolean lowStockDetected = false;

    @Given("the system has access to ingredient stock data")
    public void the_system_has_access_to_ingredient_stock_data() {
        // Mock stock data
        stockLevels.put("Flour", 10);
        stockLevels.put("Sugar", 3); // Below threshold
        stockLevels.put("Milk", 8);
        System.out.println("Stock data initialized.");
    }

    @When("the kitchen manager checks the stock levels")
    public void the_kitchen_manager_checks_the_stock_levels() {
        System.out.println("Current Stock Levels:");
        stockLevels.forEach((ingredient, level) ->
                System.out.println(ingredient + ": " + level)
        );
    }

    @Then("the system should display real-time stock levels")
    public void the_system_should_display_real_time_stock_levels() {
        System.out.println("Displaying real-time stock levels...");
        the_kitchen_manager_checks_the_stock_levels();
    }

    @Given("an ingredient's stock level is below the threshold")
    public void an_ingredient_s_stock_level_is_below_the_threshold() {
        for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
            if (entry.getValue() < THRESHOLD) {
                lowStockDetected = true;
                System.out.println(entry.getKey() + " is below threshold.");
                break;
            }
        }
    }

    @When("the system detects a low stock level")
    public void the_system_detects_a_low_stock_level() {
        if (lowStockDetected) {
            System.out.println("Low stock detected.");
        } else {
            System.out.println("All ingredients are above the threshold.");
        }
    }

    @Then("the system should suggest restocking that ingredient")
    public void the_system_should_suggest_restocking_that_ingredient() {
        if (lowStockDetected) {
            for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
                if (entry.getValue() < THRESHOLD) {
                    System.out.println("Suggested restocking: " + entry.getKey());
                }
            }
        }
    }

}
