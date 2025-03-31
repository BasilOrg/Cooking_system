package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class Feature4_2 {

    private final Map<String, Integer> stockLevels = new HashMap<>();
    private final Map<String, Double> supplierPrices = new HashMap<>();
    private final int CRITICAL_THRESHOLD = 2; // Define critical stock level
    private boolean criticalStockDetected = false;

    @Given("the system is connected to supplier databases")
    public void theSystemIsConnectedToSupplierDatabases() {
        // Mock supplier prices
        supplierPrices.put("Flour", 2.50);
        supplierPrices.put("Sugar", 1.75);
        supplierPrices.put("Milk", 3.00);
        System.out.println("Connected to supplier databases.");
    }

    @When("the kitchen manager requests ingredient prices")
    public void theKitchenManagerRequestsIngredientPrices() {
        System.out.println("Fetching real-time ingredient prices...");
        supplierPrices.forEach((ingredient, price) ->
                System.out.println(ingredient + ": $" + price + " per unit")
        );
    }

    @Then("the system should fetch and display real-time prices")
    public void theSystemShouldFetchAndDisplayRealTimePrices() {
        System.out.println("Displaying real-time prices...");
        theKitchenManagerRequestsIngredientPrices();
    }

    @Given("an ingredient's stock level is critically low")
    public void anIngredientSStockLevelIsCriticallyLow() {
        // Mock stock data
        stockLevels.put("Flour", 1); // Critically low
        stockLevels.put("Sugar", 5);
        stockLevels.put("Milk", 8);

        for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
            if (entry.getValue() <= CRITICAL_THRESHOLD) {
                criticalStockDetected = true;
                System.out.println(entry.getKey() + " is critically low.");
                break;
            }
        }
    }

    @When("the system detects the low stock level")
    public void theSystemDetectsTheLowStockLevel() {
        if (criticalStockDetected) {
            System.out.println("Critical stock detected.");
        } else {
            System.out.println("No critical stock issues.");
        }
    }

    @Then("the system should generate a purchase order automatically")
    public void theSystemShouldGenerateAPurchaseOrderAutomatically() {
        if (criticalStockDetected) {
            for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
                if (entry.getValue() <= CRITICAL_THRESHOLD) {
                    System.out.println("Generating purchase order for: " + entry.getKey());
                }
            }
        }
    }




}
