# Spartan Marketplace - Software Design

**Version:** 1.0  
**Prepared by:** Olme Matias & Omar Morales  
**Spartan Marketplace** **Oct 11, 2025**

## Table of Contents
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Provider](#221-actor-provider)
    * 2.2.2 [Actor: Customer](#222-actor-customer)
    * 2.2.3 [Actor: Administrator](#223-actor-administrator)
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

---

## Revision History
| Name | Date | Reason For Changes | Version |
| :--- | :--- | :--- | :--- |
| Olme Matias | 10/11 | Added section #1, #2.2.2, and #2.2.3 statements | 1.0 |
| Omar Morales | 10/20 | Added section #2.2.1 statements | 1.1 |

---

## 1. Product Overview
The **Spartan Marketplace** is a web-based platform designed to let customers buy or sell products and services in an easy and efficient way. Customers can browse listings, purchase services or goods, and leave reviews. Providers can post and manage their listings, view engagement statistics, and respond to feedback. The app ensures a straightforward, community-driven marketplace that allows users to resell subscriptions or items they no longer need.

---

## 2. Use Cases
### 2.1 Use Case Model
![Link to Use Case Model Diagram](https://github.com/Olme-xD/Spartan-Marketplace/tree/main/doc/Object-Oriented-Design/use-case.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Sign Up / Log In
A Provider can sign up to create their profile. They shall be able to sign in using their registered email and password to access their dashboard and manage their listings.

##### 2.2.1.2 Manage Profile
A Provider shall be able to view and update their profile information, including contact details, bio, and account settings to maintain an accurate presence on the platform.

##### 2.2.1.3 Create and Manage Listings
A Provider shall be able to create new listings for products or services, edit existing listing details, and remove listings that are no longer available on the platform.

##### 2.2.1.4 Respond to Reviews
A Provider shall be able to read reviews left by Customers and post responses to address feedback, answer questions, or thank customers for their comments.

##### 2.2.1.5 Rate Customers
After completing a transaction, a Provider shall be able to leave a rating for the Customer to help build trust and accountability within the marketplace community.

#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up / Log In
A Customer can sign up to create their profile. They shall be able to sign in using their registered email and password to access their dashboard and view their activity.

##### 2.2.2.2 Browse and Search Listings
A Customer shall be able to navigate, search, and filter through all available listings on the platform.

##### 2.2.2.3 Purchase Item or Service
A Customer shall be able to select a listing and complete a transaction to buy the product or service from the Provider.

##### 2.2.2.4 Contact Provider
A Customer shall be able to use a messaging system to contact the Provider of a listing with questions or comments.

##### 2.2.2.5 Review Provider
After purchasing a product or service, a Customer shall be able to write a review and leave a rating for the Provider and/or the product.

#### 2.2.3 Actor: Administrator
##### 2.2.3.1 Moderate Content
An Administrator shall have the ability to moderate and remove users, listings, and reviews that violate platform policies.

##### 2.2.3.2 View Statistics
An Administrator shall be able to view overall platform usage statistics, such as total users, active listings, and login activity.

---

## 3. UML Class Diagram
![Link to UML Class Diagram]()

---

## 4. Database Schema
![Link to Database Schema Diagram](https://github.com/Olme-xD/Spartan-Marketplace/tree/main/doc/Object-Oriented-Design/schema.png)