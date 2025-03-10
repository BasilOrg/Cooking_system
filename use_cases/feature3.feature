Feature: Assign tasks to chefs and kitchen staff

  As a kitchen manager,
  I want to assign tasks to chefs based on their workload and expertise
  So that I can ensure balanced workloads and efficiency.

  As a chef,
  I want to receive notifications about my assigned cooking tasks
  So that I can prepare meals on time.

  Scenario: Assign a cooking task to a chef based on expertise
    Given the kitchen has chefs with different expertise levels
    And chef "John" specializes in "Italian Cuisine"
    And chef "Anna" specializes in "Pastry"
    When a new cooking task "Make Pasta" needs to be assigned
    Then the system assigns the task to chef "John"
    And chef "John" receives a notification about the task

  Scenario: Ensure balanced workload when assigning tasks
    Given chef "John" already has 5 tasks assigned
    And chef "Anna" has 2 tasks assigned
    When a new cooking task "Bake Cake" needs to be assigned
    Then the system assigns the task to chef "Anna" to balance the workload
    And chef "Anna" receives a notification about the task

  Scenario: Notify chef about their assigned task
    Given chef "John" is assigned the task "Prepare Risotto"
    When the system sends task notifications
    Then chef "John" should receive a notification with the task details