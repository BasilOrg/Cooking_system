Feature: Store Dietary Preferences and Allergies
  In order to receive meal recommendations without unwanted ingredients
  As a customer, I want to input my dietary preferences and allergies
  And as a chef, I want to view customer dietary preferences so I can customize meals accordingly



  # Scenario: Customer inputs food preferences and allergies
  Scenario: Customer inputs dietary preferences and allergies
    Given I am a registered customer named "John Doe"
    When I navigate to the "Dietary Preferences" section
    And I enter "Vegetarian" as my dietary preference
    And I enter "Peanuts" as an allergy
    And I submit my preferences
    Then the system should store "Vegetarian" as a dietary preference for "John Doe"
    And the system should store "Peanuts" as an allergy for "John Doe"
    And I should receive a confirmation message that my information has been saved

  # Scenario: Chef presenting customer's food preferences and allergies
  Scenario: Chef views customer dietary preferences and allergies
    Given a customer "John Doe" exists with dietary preferences "Vegetarian" and allergies "Peanuts"
    And I am logged in as a chef
    When I view the profile of customer "John Doe"
    Then I should see "Vegetarian" listed under dietary preferences
    And I should see "Peanuts" listed under allergies