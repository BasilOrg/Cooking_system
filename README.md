# Special Cook Project Management System

## Overview
The **Special Cook Project Management System** is a software solution designed to streamline the management of custom cooking projects. It ensures efficiency in meal planning, ingredient sourcing, scheduling, and customer preferences. The system follows **Behavior-Driven Development (BDD)** and **Test-Driven Development (TDD) with Java**, ensuring that business requirements are well understood and tested before implementation.

## Objectives
- Automate the planning and execution of special cooking requests.
- Manage customer preferences, dietary restrictions, and order customization.
- Maintain a database or array lists of ingredients, suppliers, and cost tracking.
- Ensure seamless communication between chefs, suppliers, and customers.

## Features

### 1. Customer Profile Management
- **Store dietary preferences and allergies**
  - Customers can input their dietary preferences and allergies to receive appropriate meal recommendations.
  - Chefs can view customer preferences to customize meals accordingly.
- **Track past orders and personalized meal plans**
  - Customers can view past orders for easy reordering.
  - Chefs can access order history to suggest personalized meal plans.
  - Administrators can analyze order trends to improve services.

### 2. Order and Menu Customization
- **Custom meal requests**
  - Customers can select ingredients and customize their meals based on dietary needs.
  - The system validates ingredient combinations to prevent unavailable or incompatible selections.
- **Ingredient substitution suggestions**
  - The system suggests alternative ingredients if an ingredient is unavailable or does not meet dietary restrictions.
  - Chefs receive alerts when substitutions are applied for final approval.

### 3. Scheduling and Task Management
- **Task assignments for chefs and kitchen staff**
  - Kitchen managers can assign tasks based on workload and expertise.
  - Chefs receive notifications about assigned cooking tasks to ensure timely preparation.

### 4. Inventory and Supplier Management
- **Ingredient tracking and restocking suggestions**
  - The system monitors ingredient stock levels in real time to prevent shortages.
  - It automatically suggests restocking when ingredient levels are low.
- **Supplier integration for real-time pricing and ordering**
  - Fetches real-time ingredient prices from suppliers for cost-effective purchasing.
  - Automatically generates purchase orders when stock is critically low.

### 5. Billing System
- **Invoice generation and financial tracking**
  - Customers receive invoices for their orders.
  - Administrators generate financial reports to analyze revenue and business performance.

### 6. Notifications and Alerts
- **Reminders for upcoming orders and deliveries**
  - Customers receive reminders for upcoming meal deliveries.
  - Chefs get notifications for scheduled cooking tasks.
- **Stock level alerts**
  - Kitchen managers receive low-stock alerts to reorder ingredients before running out.

### 7. AI Assistance
- **Recipe Recommendation Assistant**
  - The system can use AI models to recommend recipes based on dietary preferences and available ingredients.
  - Example prompt:
    > "You are a recipe recommendation assistant. A user has the following preferences:
    > - Dietary restrictions: Vegan.
    > - Ingredients available: Tomatoes, basil, pasta.
    > - Time available: 30 minutes.
    > Recommend the best recipe from the database and explain your choice."

## Technologies Used
- **Programming Language:** Java
- **Development Approach:** Behavior-Driven Development (BDD), Test-Driven Development (TDD)
- **Database Management:** Array lists or a structured database for ingredient tracking
- **Integration:** Supplier APIs for real-time pricing and inventory management
- **AI Models:** Used for recipe recommendations

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/special-cook.git
   ```
2. Navigate to the project directory:
   ```sh
   cd special-cook
   ```
3. Install dependencies:
   ```sh
   mvn install  # If using Maven
   ```
4. Run the application:
   ```sh
   java -jar special-cook.jar
   ```

## Contribution Guidelines
- Fork the repository and create a new branch for your feature.
- Commit your changes with descriptive messages.
- Open a pull request for review.
- Ensure all tests pass before merging.

## License
This project is licensed under the **MIT License**.

## Contact
For any questions or support, reach out to barakatbasil79@gmail.com.

