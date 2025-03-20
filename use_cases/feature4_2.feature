Feature: Supplier Integration for Real-time Pricing and Ordering

  Scenario: Fetch real-time ingredient prices from suppliers
    Given the system is connected to supplier databases
    When the kitchen manager requests ingredient prices
    Then the system should fetch and display real-time prices

  Scenario: Automatically generate purchase orders for low stock
    Given an ingredient's stock level is critically low
    When the system detects the low stock level
    Then the system should generate a purchase order automatically