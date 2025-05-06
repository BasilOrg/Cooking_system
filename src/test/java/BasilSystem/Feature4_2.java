package BasilSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Ingredient;
import org.example.PurchaseOrder;
import org.example.Supplier;

import java.util.*;

import static org.junit.Assert.*;


public class Feature4_2 {
    private List<Ingredient> ingredients;
    private Map<Ingredient, Supplier> ingredientToSupplier;
    private Map<Ingredient, Double> fetchedPrices;
    private List<PurchaseOrder> purchaseOrders;
    @Given("the system is integrated with suppliers")
    public void theSystemIsIntegratedWithSuppliers() {
// Create suppliers with their respective prices
        Supplier supplier1 = new Supplier("Supplier1", 10.0);
        Supplier supplier2 = new Supplier("Supplier2", 12.0);

        // Create ingredients without supplier information
        Ingredient tomato = new Ingredient("Tomato", 50, 20);
        Ingredient potato = new Ingredient("Potato", 30, 10);

        // Initialize ingredient list
        ingredients = Arrays.asList(tomato, potato);

        // Map ingredients to their suppliers
        ingredientToSupplier = new HashMap<>();
        ingredientToSupplier.put(tomato, supplier1);
        ingredientToSupplier.put(potato, supplier2);
    }

    @When("the kitchen manager requests current prices")
    public void theKitchenManagerRequestsCurrentPrices() {
        fetchedPrices = new HashMap<>();
        System.out.println("\nFetching current prices:");
        for (Ingredient ingredient : ingredients) {
            Supplier supplier = ingredientToSupplier.get(ingredient);
            if (supplier != null) {
                double price = supplier.getPriceFor(ingredient);
                fetchedPrices.put(ingredient, price);
                System.out.println("- " + ingredient.getName() + ": " + price + " from " + supplier.getName());
            }
        }
    }

    @Then("the system displays the real-time prices from suppliers")
    public void theSystemDisplaysTheRealTimePricesFromSuppliers() {
        assertNotNull(fetchedPrices);
        assertEquals(ingredients.size(), fetchedPrices.size());
        System.out.println("\nVerifying fetched prices:");
        for (Ingredient ingredient : ingredients) {
            Supplier supplier = ingredientToSupplier.get(ingredient);
            assertTrue(fetchedPrices.containsKey(ingredient));
            assertEquals(supplier.getPriceFor(ingredient), fetchedPrices.get(ingredient), 0.01);
            System.out.println("- " + ingredient.getName() + " price verified: " + fetchedPrices.get(ingredient));
        }
    }

    @Given("the system is configured to monitor stock levels")
    public void theSystemIsConfiguredToMonitorStockLevels() {
        System.out.println("\nSystem configured to monitor stock levels.");
    }

    @When("stock levels drop below the critical threshold")
    public void stockLevelsDropBelowTheCriticalThreshold() {
        System.out.println("\nStock levels dropping below critical threshold:");
        for (Ingredient ingredient : ingredients) {
            int newStock = ingredient.getThreshold() - 1;
            ingredient.setCurrentStock(newStock);
            System.out.println("- " + ingredient.getName() + ": Stock = " + newStock + " (Threshold = " + ingredient.getThreshold() + ")");
        }
    }

    @Then("the system automatically generates purchase orders")
    public void theSystemAutomaticallyGeneratesPurchaseOrders() {
        purchaseOrders = new ArrayList<>();
        System.out.println("\nGenerating purchase orders:");
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getCurrentStock() < ingredient.getThreshold()) {
                Supplier supplier = ingredientToSupplier.get(ingredient);
                if (supplier != null) {
                    double price = supplier.getPriceFor(ingredient);
                    int quantityToOrder = 100 - ingredient.getCurrentStock();
                    PurchaseOrder order = new PurchaseOrder(ingredient, quantityToOrder, price);
                    purchaseOrders.add(order);
                    System.out.println("- Order for " + ingredient.getName() + ": Quantity = " + quantityToOrder + ", Price = " + price);
                }
            }
        }
        assertFalse(purchaseOrders.isEmpty());
        assertEquals(ingredients.size(), purchaseOrders.size());
        System.out.println("\nVerifying purchase orders:");
        for (PurchaseOrder order : purchaseOrders) {
            Ingredient ingredient = order.getIngredient();
            Supplier supplier = ingredientToSupplier.get(ingredient);
            int expectedQuantity = 100 - ingredient.getCurrentStock();
            assertEquals(expectedQuantity, order.getQuantity());
            assertEquals(supplier.getPriceFor(ingredient), order.getPrice(), 0.01);
            System.out.println("- " + ingredient.getName() + ": Quantity = " + order.getQuantity() + ", Price = " + order.getPrice() + " verified");        }
    }
    }





