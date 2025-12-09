## Title
> Spartan Marketplace
## Team Members
> Olme Matias Molina \
> Omar Morales
## Description
> This Spartan Marketplace is meant to let customers buy or sell products or services to others. The main motivation behind this app is to create a platform to let users sells things they do not no longer want or need. The Spartan Marketplace will also allow customers/providers sell subscriptions they do not longer want. Eliminating potential waste and providing users with the opportunity to receive some compensation.
## App Functions
1. Customer (the user with the customer role):
    1. Create/modify customer profile - The system shall provide a login system for the customer.
    2. View available services - The system shall provide an option to view listings.
    3. Subscribe to available services - The system shall provide en option to view contacts of the listing.
    4. Write reviews for subscribed services - The system shall provide an option to write a review.
2. Provider (the user with the provider role):
    1. Create/modify/remove provider profile - The system shall provide a login system for the provider.
    2. Create services - The system shall provide an option to create/remove listings.
    3. View customer statistics - The system shall provide an option to view customers retention .
    4. Reply to reviews - The system shall provide ratings as well as reviews on customer's profile.
3. SysAdmin (the user with the admin role if applicable):
    1. Manage user access - The system shall provide control customer/provider access to the platform.
    2. Moderate services - The system shall provide control by admin approval of their services or products.
    3. Moderate reviews - The system shall provide regulation and moderate customer/provider reviews.

    4. View usage statistics - The system shall provide view the tools to see statistics about overall user usages (clicks, views, logins, products sold, and services).

ReadME: 
Installation
•	Get the project 
o	clone
        git clone [https://github.com/csc340-uncg/f25-mvc-demo.git](https://github.com/Olme-xD/Spartan-Marketplace)
- OR download zip.
•	Open the project in VS Code.
•	This project is built to run with jdk 21.
•	Dependencies to JPA, Postgres, and Fetch, in addition to the usual. JPA handles the persistence, Postgres is the database to be used, Fetch generates HTML templates.
•	/src/main/resources/application.properties file is the configuration for the app.
•	You MUST have the database up and running before running the project! 
o	Login to your neon.tech account.
o	Locate your database project.
o	On the project dashboard, click on "Connect" and select Java.
o	Copy the connection string provided.
o	Paste it as a value for the property spring.datasource.url. No quotation marks.
•	Build and run the main class. You should see new tables created in the Neon database.
## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/Olme-xD/Spartan-Marketplace
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies] Dependencies to JPA, Postgres, and Fetch, in addition to the usual. JPA handles the persistence, Postgres is the database to be used, Fetch generates HTML templates.
- [`/src/main/resources/application.properties`]([https://github.com/csc340-uncg/f25-mvc-demo/blob/5b89c8a320f3f99cac0f79d110f90258ff9a65ae/src/main/resources/application.properties](https://github.com/Olme-xD/Spartan-Marketplace/blob/main/backend-api/src/main/resources/application.properties)) file  is the configuration for the app.
 - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.
