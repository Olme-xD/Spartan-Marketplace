# Software Requirements Specification
## For <Craig List App>

Version 0.1  
Prepared by Olme Matias & Omar Morales  
CSC340  
September 7, 2025 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
|    Name   |   Date  |             Reason For Changes              | Version   |
| --------- | ------- | ------------------------------------------- | --------- |
|Olme Matias|   9/7   | Added section #1 statements                 |  1.0      |
|Olme Matias|   9/13  | Added functional requirements for customers |  1.1      |
|Omar Morales|  9/17  | Added section #2 statements                 |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Document (SRD) is to describe the client-oriented and developer-oriented requirements for the Craig List App website.
Client-oriented requirements describe the system from the client’s perspective. These requirements include a description of the different types of users served by the system.
Developer-oriented requirements describe the system from a software developer’s perspective. These requirements include a detailed description of functional, data, performance, and other important requirements.

### 1.2 Product Scope
The purpose of our Craigslist App is to help consumers and providers easily buy and sell products and services. This web-based application simplifies subscription management and makes it easier to manage products, ensuring a straightforward experience for everyone.

### 1.3 Definitions, Acronyms and Abbreviations

| Reference  | Definition                                                                                                                                                                         |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java       | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub.                 |
| Postgresql | Open-source relational database management system.                                                                                                                                 |
| Webstudio  | Open-source web builder that will be used to build our web application.                                                                                                                                         |
| API        | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                  |
| HTML       | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS        | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                    |
| JavaScript | An object-oriented computer programming language commonly used to create interactive effects within web browsers. Will be used in conjuction with HTML and CSS to make the web app. |
| VS Code    | An integrated development environment (IDE). This is where our system will be created.                                                                                             |

### 1.4 References
https://webstudio.is/

### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers and business stakeholders. Section 3 specifies the requirements and constraints for the product and development process. This section is intended for all stakeholders, especially the development team.

## 2. Product Overview
The Craig List app is a web-based platform designed to let customers buy or sell products and services in an easy and efficient way. Customers can browse listings, purchase services or goods, leave reviews. Providers can post and manage their listings, view engagement statistics, and respond to feedback. Administrators manage platform moderation and overall usage statistics. The app nensures a straightforward, community-driven marketplace that minimizes waste by allowing users to resell subscriptions or items they no longer need.

### 2.1 Product Functions
The Craig List App supports three primary roles:
- Customers: Create and manage profiles, browse listings, contact providers, purchase item/services, and write reviews.
- Provider: Create, edit and remove listings, track customer engagement and respond to customer reviews.
- Administrator: Moderate users, services and reviews, and view usage statistics such as views, logins.

### 2.2 Product Constraints
The program will only run on devices with a modern web browser that supports HTML, CSS, and JavaScript. Development is expected to be completed at zero cost, limiting tool and hosting options. The deadline for deployment is December 11, 2025, which may restrict features. The system also depends on Webstudio for frontend development and PostgreSQL for database management, which may affect scalability.
  
### 2.3 User Characteristics
The application is designed for users with little technical experience beyond browsing the web. Customers should be able to use the system effectively after a few sessions. Providers may have slightly more technical knowledge, as they manage multiple listings and track engagement. Administrators require higher expertise to handle moderation and system management.

### 2.4 Assumptions and Dependencies
The system assumes users have reliable internet access and that hosting services remain available. It depends on Webstudio for building the frontend, PostgreSQL for data storage, and APIs for authentication, messaging, and payments. The system also assumes that payment gateways and third-party APIs remain reliable and secure throughout development and operation.

## 3. Requirements

### 3.1 Functional Requirements  
* FR0: The system shall allow users to create a profile.
* FR1: The system shall allow users to create a new listing for the product or service.
* FR2: The system shall allow users navigate through all the available listing.
* FR3: The system shall allow users to buy the product or service from other users (creator of the listing).
* FR4: The system shall allow users to contact the creator of the listing.
* FR5: The system shall allow users to review the creator of the listing and/or the product.
* FR6: The system shall allow creators of listing rate the customer.
* FR7: The system shall allow creators of listing reply to users reviews.
* FR8: The system shall allow administrators to moderate users, listings and reviews.
* FR9: The system shall allow administrators to view usage statistics.

#### 3.1.1 User interfaces
The user interface will be a standard web application designed to be responsive across various screen sizes. It will use a clean, intuitive layout to minimize the learning curve for new users. Interface components include:
* Login/Registration Page: A form for creating new accounts and logging in.
* Dashboard/Profile Page: A page for users to manage their profiles, view their listings, and see their reviews.
* Listing Creation Page: A form with fields for product/service details, price, description, and images.
* Search/Browse Page: A searchable list of all available listings with filtering and sorting options.
* Listing Detail Page: A page displaying all information about a listing, and the creator.
* Messaging System: A private messaging interface for communication between users.

#### 3.1.2 Hardware interfaces
The system will operate on any device that has an up-to-date web browser capable of rendering HTML, CSS, and JavaScript.

#### 3.1.3 Software interfaces
* Java JDK 21 will be used as the development platform to build the backend service. It provides the runtime environment necessary to execute the application.
* PostgreSQL 17 will serve as the relational database management system, responsible for storing user profiles, listings, transactions, and reviews.
* SpringBoot 3.4.5 will be used as the backend framework to manage server-side logic, handle HTTP requests, and connect with the database.
* Webstudio will be used for frontend development to ensure a responsive and user-friendly interface.

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
* NFR0: The system shall allow the user to create an account in less than 3 minutes.
* NFR1: The system shall allow the user to create a listing in less than 6 minutes.

#### 3.2.2 Security
* NFR2: The system shall not allow non-registered users see other user's profile information.

#### 3.2.3 Reliability

#### 3.2.4 Availability
* NFR3: The system will be available 24/7. It will use a reliable hosting provider to handle periods of high traffic.

#### 3.2.5 Compliance

#### 3.2.6 Cost
* NFR4: We expect to spend zero dollars on this project.

#### 3.2.7 Deadline
* NFR5: The software product is scheduled for delivery and deployment on 12/11/2025.