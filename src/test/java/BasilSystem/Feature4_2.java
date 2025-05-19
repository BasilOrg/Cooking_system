package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Ingredient;
import org.example.KitchenManager;
import org.example.PurchaseOrder;
import org.example.Supplier;

import java.util.*;

import static org.junit.Assert.*;


public class Feature4_2 {

    private Map<Ingredient, Double> fetchedPrices;
    private KitchenManager kitchenManager;
    private List<Ingredient> lowStockIngredients;




    @Given("the system is integrated with suppliers")
    public void theSystemIsIntegratedWithSuppliers() {
// Create suppliers with their respective prices
        kitchenManager = new KitchenManager();

        // Register suppliers
        Supplier supplier1 = new Supplier("Supplier1", 10.0);
        Supplier supplier2 = new Supplier("Supplier2", 12.0);
        kitchenManager.registerSupplier(supplier1);
        kitchenManager.registerSupplier(supplier2);

        // Add ingredients
        kitchenManager.addIngredient("Tomato", 50, 20);
        kitchenManager.addIngredient("Potato", 30, 10);
    }

    @When("the kitchen manager requests current prices")
    public void theKitchenManagerRequestsCurrentPrices() {
        fetchedPrices = new HashMap<>();
        System.out.println("\nFetching current prices:");
        for (Supplier supplier : kitchenManager.getSuppliers()) {
            for (String ingredientName : List.of("Tomato", "Potato")) {
                Ingredient ingredient = kitchenManager.getIngredient(ingredientName);
                double price = supplier.getPriceFor(ingredient);
                fetchedPrices.put(ingredient, price);
                System.out.println("- " + ingredient.getName() + ": " + price + " from " + supplier.getName());
            }
        }
    }

    @Then("the system displays the real-time prices from suppliers")
    public void theSystemDisplaysTheRealTimePricesFromSuppliers() {
        assertNotNull(fetchedPrices);
        assertFalse(fetchedPrices.isEmpty());

        System.out.println("\nVerifying fetched prices:");
        for (Map.Entry<Ingredient, Double> entry : fetchedPrices.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double price = entry.getValue();
            assertTrue(price > 0);
            System.out.println("- " + ingredient.getName() + " verified price: " + price);
        }
    }

    @Given("the system is configured to monitor stock levels")
    public void theSystemIsConfiguredToMonitorStockLevels() {
        System.out.println("\nStock level monitoring enabled.");
        kitchenManager.displayStockLevels();    }

    @When("stock levels drop below the critical threshold")
    public void stockLevelsDropBelowTheCriticalThreshold() {
        System.out.println("\nSimulating stock level drop:");
        for (String ingredientName : List.of("Tomato", "Potato")) {
            Ingredient ingredient = kitchenManager.getIngredient(ingredientName);
            int criticalLevel = ingredient.getThreshold() - 1;
            ingredient.setCurrentStock(criticalLevel);
            System.out.println("- " + ingredient.getName() + " stock reduced to " + criticalLevel);
        }
    }

    @Then("the system automatically generates purchase orders")
    public void theSystemAutomaticallyGeneratesPurchaseOrders() {
        lowStockIngredients = kitchenManager.getLowStockIngredients();
        assertFalse(lowStockIngredients.isEmpty());

        System.out.println("\nCreating purchase orders for low stock ingredients:");
        for (Ingredient ingredient : lowStockIngredients) {
            Supplier supplier = kitchenManager.findSupplierFor(ingredient.getName());
            double price = supplier.getPriceFor(ingredient);
            int quantityToOrder = 100 - ingredient.getCurrentStock();
            PurchaseOrder po = new PurchaseOrder(ingredient, quantityToOrder, price);
            kitchenManager.storePurchaseOrder(po);

            System.out.println("- PurchaseOrder: " + ingredient.getName() + ", Qty: " + quantityToOrder + ", Price: " + price);
        }

        List<PurchaseOrder> orders = kitchenManager.getPurchaseOrders();
        assertEquals(lowStockIngredients.size(), orders.size());

        System.out.println("\nVerifying stored purchase orders:");
        for (PurchaseOrder order : orders) {
            Ingredient ing = order.getIngredient();
            int expectedQty = 100 - ing.getCurrentStock();
            assertEquals(expectedQty, order.getQuantity());
            assertTrue(order.getPrice() > 0);
            System.out.println("- Verified order for " + ing.getName() + ": Qty = " + order.getQuantity() + ", Price = " + order.getPrice());
        }
    }
}




