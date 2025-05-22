
package org.example;



import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize KitchenManager and default Supplier
        KitchenManager kitchen = new KitchenManager();
        Supplier defaultSupplier = new Supplier("Global Foods", 2.5);
        kitchen.registerSupplier(defaultSupplier);

        // Add ingredients
        kitchen.addIngredient("Tomatoes", 5, 10);
        kitchen.addIngredient("Flour", 50, 20);
        kitchen.addIngredient("Cheese", 2, 5);

        // Initial stock display
        kitchen.displayStockLevels();

        // Low stock check and orders
        List<Ingredient> lowStock = kitchen.getLowStockIngredients();
        if (!lowStock.isEmpty()) {
            System.out.println("Low stock detected. Generating purchase orders:");
            for (Ingredient ing : lowStock) {
                int qty = ing.getThreshold() * 2 - ing.getCurrentStock();
                PurchaseOrder po = new PurchaseOrder(ing, qty, defaultSupplier.getPriceFor(ing));
                kitchen.storePurchaseOrder(po);
                System.out.println("Order " + po.getQuantity() + " of " + ing.getName() +
                        " at $" + po.getPrice() + " from " + defaultSupplier.getName());
            }
        }

        // Setup chefs
        Chef alice = new Chef(); alice.setTaskCount(0); alice.setName("Basil"); alice.setSpecialization("Arabic Food");
        Chef bob   = new Chef(); bob.setTaskCount(0);   bob.setName("Majid");   bob.setSpecialization("Italian Food");
        kitchen.storeChef(alice); kitchen.storeChef(bob);

        List<Chef> chefs = List.of(alice, bob);

        // Initial tasks
        alice.assignTask("Bake croissants");
        bob.assignTask("Grill steaks");

        // Predefined customers
        Customer c1 = new Customer(); c1.setName("Charlie"); c1.setDietaryPreference("Vegetarian"); c1.setAllergy("Nuts"); Customer.storeCustomer(c1);
        Customer c2 = new Customer(); c2.setName("Dana");    c2.setDietaryPreference("Gluten-Free");  c2.setAllergy("Dairy"); Customer.storeCustomer(c2);

        Scanner scanner = new Scanner(System.in);

        // Customer entry
        System.out.println("Enter your information:");
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Dietary Presences: "); String diet = scanner.nextLine();
        System.out.print("Allergy: "); String allergy = scanner.nextLine();
        Customer newC = new Customer(); newC.setName(name); newC.setDietaryPreference(diet); newC.setAllergy(allergy);
        Customer.storeCustomer(newC);
        System.out.println("Stored customer: " + newC);



        // Order placement
        System.out.print("Place order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Dish: "); String dish = scanner.nextLine();
            System.out.print("Chef spec: "); String spec = scanner.nextLine();
            boolean done=false;
            for(Chef ch: chefs)
                if(ch.getSpecialization().equalsIgnoreCase(spec)){
                    ch.assignTask(dish);
                    System.out.println("Assigned " + dish + " to " + ch.getName()); done=true; break; }
            if(!done) System.out.println("No chef for: " + spec);
            System.out.println("\nOrder summary:");
            for(Chef ch: chefs)
                System.out.println(ch.getName()+" ("+ch.getSpecialization()+") has " + ch.getTaskCount()+" orders");
        }

           else System.exit(0);


        // Manager actions
        System.out.print("\nKitchen Manager? Check stocks or suppliers? (stock/supplier/none):");
        String managerAction  = scanner.nextLine();
        if(managerAction .equalsIgnoreCase("stock")){
            System.out.println("Stock levels:"); kitchen.displayStockLevels();
        } else if(managerAction .equalsIgnoreCase("supplier")){
            System.out.print("Ingredient for supplier: "); String ing= scanner.nextLine();
            Supplier sp = kitchen.findSupplierFor(ing);
            if(sp!=null) System.out.println("Supplier: " + sp.getName() + " @ $" + sp.getPriceFor(new Ingredient(ing,0,0)));
            else System.out.println("No supplier for " + ing);
        }
            else{
                System.exit(0);
            System.out.println("Done.");

            }
        }

}



/*

private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Configure logger to show on console
        logger.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        logger.addHandler(handler);

        // Initialize KitchenManager and default Supplier
        KitchenManager kitchen = new KitchenManager();
        Supplier defaultSupplier = new Supplier("Global Foods", 2.5);
        kitchen.registerSupplier(defaultSupplier);

        // Add ingredients with low and sufficient stock
        kitchen.addIngredient("Tomatoes", 5, 10);
        kitchen.addIngredient("Flour", 50, 20);
        kitchen.addIngredient("Cheese", 2, 5);

        // Display current stocks initially
        kitchen.displayStockLevels();

        // Check low-stock ingredients and create purchase orders
        List<Ingredient> lowStock = kitchen.getLowStockIngredients();
        if (!lowStock.isEmpty()) {
            logger.info("Low stock detected. Generating purchase orders:");
            for (Ingredient ing : lowStock) {
                int toOrder = ing.getThreshold() * 2 - ing.getCurrentStock();
                PurchaseOrder po = new PurchaseOrder(ing, toOrder, defaultSupplier.getPriceFor(ing));
                kitchen.storePurchaseOrder(po);
                logger.info(String.format("Order %d of %s at $%.2f each from %s",
                        po.getQuantity(),
                        po.getIngredient().getName(),
                        po.getPrice(),
                        defaultSupplier.getName()));
            }
        }

        // Register chefs
        Chef alice = new Chef();
        alice.setTaskCount(0);
        alice.setName("Alice");
        alice.setSpecialization("Pastry");
        kitchen.storeChef(alice);

        Chef bob = new Chef();
        bob.setTaskCount(0);
        bob.setName("Bob");
        bob.setSpecialization("Grill");
        kitchen.storeChef(bob);

        List<Chef> chefs = List.of(alice, bob);

        // Assign initial tasks
        alice.assignTask("Bake croissants");
        bob.assignTask("Grill steaks");

        // Predefined customers
        Customer c1 = new Customer();
        c1.setName("Charlie");
        c1.setDietaryPreference("Vegetarian");
        c1.setAllergy("Nuts");
        Customer.storeCustomer(c1);

        Customer c2 = new Customer();
        c2.setName("Dana");
        c2.setDietaryPreference("Gluten-Free");
        c2.setAllergy("Dairy");
        Customer.storeCustomer(c2);

        // Interactive console
        Scanner scanner = new Scanner(System.in);


        // Customer flow
        System.out.println("Enter your customer information:");
        System.out.print("Name: ");
        String custName = scanner.nextLine();
        System.out.print("Dietary Preference: ");
        String dietary = scanner.nextLine();
        System.out.print("Allergy: ");
        String allergy = scanner.nextLine();

        Customer newCustomer = new Customer();
        newCustomer.setName(custName);
        newCustomer.setDietaryPreference(dietary);
        newCustomer.setAllergy(allergy);
        Customer.storeCustomer(newCustomer);
        logger.info("New customer stored: " + newCustomer);

        // Search customer
        System.out.print("Enter a name to search for customer: ");
        String searchName = scanner.nextLine();
        logger.info("Searching for customer '" + searchName + "':");
        Customer.searchCustomerName(searchName);

        // Place an order
        System.out.print("Would you like to place an order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Dish name: ");
            String dish = scanner.nextLine();
            System.out.print("Required chef specialization: ");
            String spec = scanner.nextLine();
            boolean assigned = false;
            for (Chef chef : chefs) {
                if (chef.getSpecialization().equalsIgnoreCase(spec)) {
                    chef.assignTask(dish);
                    logger.info("Order placed: " + dish + " assigned to Chef " + chef.getName());
                    assigned = true;
                    break;
                }
            }
            if (!assigned) logger.warning("No chef available with specialization: " + spec);

            System.out.println("\nOrders summary:");
            for (Chef chef : chefs) {
                System.out.printf("%s (%s): %d orders%n",
                        chef.getName(), chef.getSpecialization(), chef.getTaskCount());
            }
        }

        // Manager flow: check stocks and suppliers
        System.out.print("\nKitchen Manager? Check stocks or suppliers? (stock/supplier/none): ");
        String managerAction = scanner.nextLine();
        if (managerAction.equalsIgnoreCase("stock")) {
            System.out.println("\n-- Stock Levels --");
            kitchen.displayStockLevels();
        } else if (managerAction.equalsIgnoreCase("supplier")) {
            System.out.print("Enter ingredient name to view supplier: ");
            String ingName = scanner.nextLine();
            Supplier sup = kitchen.findSupplierFor(ingName);
            if (sup != null) {
                System.out.printf("Supplier for %s: %s at $%.2f per unit%n",
                        ingName, sup.getName(), sup.getPriceFor(new Ingredient(ingName,0,0)));
            } else {
                System.out.println("No supplier found for ingredient: " + ingName);
            }
        }

        logger.info("Application complete.");
    }


 */