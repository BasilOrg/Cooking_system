



  Feature: Store Dietary Preferences and Allergies

  As a customer, I want to input my dietary preferences and allergies
  And as a chef, I want to view customer dietary preferences so I can customize meals accordingly



  # Scenario: Customer inputs food preferences and allergies
  Scenario: empty Information
    Then the field 'Name' should be error
    And  the field 'dietaryPresences' should be error
    And  the field 'Allergies' should be error


  Scenario: successful information

    Then he fill in 'Name' with 'Basil'
    And he fill in 'dietaryPresences' with 'Vegetarian'
    And he fill in 'Allergies' with 'Peanuts'
    Then the system should store "Vegetarian" as a dietary preference and "Peanuts" for "Basil"
    And I should receive a confirmation message that my information has been saved


    Scenario Outline: I errors with input
      When user click on insert order and flag is 'true'
      And he fill in 'Name' with '<Name>'
      And he fill in 'dietaryPresences' with '<dietaryPresences>'
      And he fill in 'Allergies' with '<Allergies>'
      Then the user should see '<message>'
      Examples:
        | Name  | dietaryPresences | Allergies | message |
        | Basil |    1             | Peanuts   | dietaryPresences must be a String |
        | Basil |    Vegan         | 1         | Allergies must be  a String       |
        | Tree  |   Vegan          | Peanut    | Name is Invalid                   |
        | 0     |   Vegan          | Peanut    | Name must be A a string           |
        | Basil |   car            | Peanut    | dietaryPresences is Invalid       |
        | Tree  |   Vegan          | cat       | Allergies is Invalid              |



    Scenario: Chef retrieves a customer's dietary preferences
      When I retrieve the preferences for "Alice"
      Then I should see "Vegan" in dietary preferences
      And  I should see "Peanuts" in allergies