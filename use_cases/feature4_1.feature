Feature: Inventory Tracking and Restocking

  Scenario: Track ingredient stock levels in real-time
    Given the system has access to ingredient stock data
    When the kitchen manager checks the stock levels
    Then the system should display real-time stock levels

  Scenario: Suggest restocking when stock is low
    Given an ingredient's stock level is below the threshold
    When the system detects a low stock level
    Then the system should suggest restocking that ingredient