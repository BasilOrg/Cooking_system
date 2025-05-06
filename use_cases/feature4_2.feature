





Feature: Integrate with suppliers for real-time pricing and ordering

  Background:
    Given the system is integrated with suppliers

  Scenario: Fetch real-time ingredient prices
    When the kitchen manager requests current prices
    Then the system displays the real-time prices from suppliers

  Scenario: Automatically generate purchase orders for low stock
    Given the system is configured to monitor stock levels
    When stock levels drop below the critical threshold
    Then the system automatically generates purchase orders