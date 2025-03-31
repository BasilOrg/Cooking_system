Special Cook Project Management System – User 
Stories 
Overview 
The Special Cook Project Management System is a software solution designed to streamline 
the management of custom cooking projects, ensuring efficiency in meal planning, ingredient 
sourcing, scheduling, and customer preferences. The system will be developed using 
Behavior-Driven Development (BDD), TDD with Java, ensuring that business requirements are 
well understood and tested before implementation. 
Objectives 
● Automate the planning and execution of special cooking requests. 
● Manage customer preferences, dietary restrictions, and order customization. 
● Maintain a database or Array lists of ingredients, suppliers, and cost tracking. 
● Ensure seamless communication between chefs, suppliers, and customers. 
1. Customer Profile Management 
1.1 Store dietary preferences and allergies 
● As a customer, I want to input my dietary preferences and allergies so that the system 
can recommend appropriate meals and prevent unwanted ingredients. 
● As a chef, I want to view customer dietary preferences so that I can customize meals 
accordingly. 
1.2 Track past orders and personalized meal plans 
● As a customer, I want to view my past meal orders so that I can reorder meals I liked. 
● As a chef, I want to access customers’ order history so that I can suggest personalized 
meal plans. 
● As a system administrator, I want to store and retrieve customer order history so that I 
can analyze trends and improve service offerings. 
2. Order and Menu Customization 
2.1 Allow customers to create custom meal requests 
● As a customer, I want to select ingredients and customize my meal so that I can order 
meals according to my taste and dietary needs. 
● As a system, I want to validate ingredient combinations so that customers do not select 
incompatible or unavailable ingredients. 
2.2 Suggest ingredient substitutions based on dietary restrictions 
● As a customer, I want the system to suggest alternative ingredients if an ingredient is 
unavailable or does not fit my dietary restrictions so that I can enjoy my meal without 
compromising my health. 
● As a chef, I want to receive an alert when an ingredient substitution is applied so that I 
can approve or adjust the final recipe. 
3. Scheduling and Task Management 
3.1 Assign tasks to chefs and kitchen staff 
● As a kitchen manager, I want to assign tasks to chefs based on their workload and 
expertise so that I can ensure balanced workloads and efficiency. 
● As a chef, I want to receive notifications about my assigned cooking tasks so that I can 
prepare meals on time. 
4. Inventory and Supplier Management 
4.1 Track available ingredients and suggest restocking 
● As a kitchen manager, I want to track ingredient stock levels in real time so that I can 
prevent shortages and ensure continuous operations. 
● As a system, I want to automatically suggest restocking when ingredients are low so that 
kitchen managers can take action promptly. 
4.2 Integrate with suppliers for real-time pricing and ordering 
● As a kitchen manager, I want the system to fetch real-time ingredient prices from 
suppliers so that I can make cost-effective purchasing decisions. 
● As a system, I want to automatically generate purchase orders when stock levels are 
critically low so that supplies are replenished without manual intervention. 
5. Billing System 
5.1 Generate invoices and track financial reports 
● As a customer, I want to receive an invoice. 
● As a system administrator, I want to generate financial reports so that I can analyze 
revenue and track business performance. 
6. Notifications and Alerts 
6.1 Send reminders for upcoming orders and deliveries 
● As a customer, I want to receive reminders for my upcoming meal deliveries so that I can 
be prepared to receive them. 
● As a chef, I want to get notified of scheduled cooking tasks so that I can prepare meals 
on time. 
6.2 Notify users of low-stock ingredients  
● As a kitchen manager, I want to receive alerts when stock levels are low so that I can 
reorder before running out of ingredients. 
7. AI assistance 
You can use any available LLM as a recipe recommendation assistant. You can use the 
following prompt.  
You are a recipe recommendation assistant. A user has the following preferences: - Dietary restrictions: Vegan. - Ingredients available: Tomatoes, basil, pasta. - Time available: 30 minutes. 
Recommend the best recipe from the following database: 
1. Spaghetti with Tomato Sauce (Ingredients: Tomatoes, pasta, basil, olive oil. Time: 25 minutes. 
Vegan.) 
2. Tomato Basil Soup (Ingredients: Tomatoes, basil, garlic. Time: 40 minutes. Vegan.) 
3. Vegan Pesto Pasta (Ingredients: Basil, pasta, olive oil, garlic. Time: 20 minutes. Vegan.) 
Explain your recommendation clearly. 
