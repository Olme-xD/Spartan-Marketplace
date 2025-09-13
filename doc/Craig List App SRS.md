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
|    Name   |  Date |     Reason For Changes    | Version   |
| --------- | ----- | ------------------------- | --------- |
|Olme Matias|  9/7  | Added consumer statements |  1.0      |
|           |       |                           |           |
|           |       |                           |           |

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
This section should describe the general factors that affect the product and its requirements. This section does not state specific requirements. Instead, it provides a background for those requirements, which are defined in detail in Section 3, and makes them easier to understand.

### 2.1 Product Functions
Summarize the major functions the product must perform or must let the user perform. Details will be provided in Section 3, so only a high level summary (such as a bullet list) is needed here. Organize the functions to make them understandable to any reader of the SRS. A picture of the major groups of related requirements and how they relate, such as a top level data flow diagram or object class diagram, is often effective.

### 2.2 Product Constraints
This subsection should provide a general description of any other items that will limit the developer’s options. These may include:  

* Interfaces to users, other applications or hardware.  
* Quality of service constraints.  
* Standards compliance.  
* Constraints around design or implementation.
  
### 2.3 User Characteristics
Identify the various user classes that you anticipate will use this product. User classes may be differentiated based on frequency of use, subset of product functions used, technical expertise, security or privilege levels, educational level, or experience. Describe the pertinent characteristics of each user class. Certain requirements may pertain only to certain user classes. Distinguish the most important user classes for this product from those who are less important to satisfy.

### 2.4 Assumptions and Dependencies
List any assumed factors (as opposed to known facts) that could affect the requirements stated in the SRS. These could include third-party or commercial components that you plan to use, issues around the development or operating environment, or constraints. The project could be affected if these assumptions are incorrect, are not shared, or change. Also identify any dependencies the project has on external factors, such as software components that you intend to reuse from another project, unless they are already documented elsewhere (for example, in the vision and scope document or the project plan).

## 3. Requirements

### 3.1 Functional Requirements  
* FR0: The system will allow users to create a profile.
* FR1: The system will allow users to create a new listing for the product or service.
* FR2: The system will allow users navigate through all the available listing.
* FR3: The system will allow users to buy the product or service from other users (creator of the listing).
* FR4: The system will allow users to contact the creator of the listing.
* FR5: The system will allow users to review the creator of the listing and/or the product.
* FR6: The system will allow creators of listing rate the customer.
* FR7: The system will allow creators of listing reply to users reviews.
* FR8: The system will allow administrators to moderate users, listings and reviews.
* FR9: The system will allow administrators to view usage statistics.

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



------------
Describe the connections between this product and other specific software components (name and version), including databases, operating systems, tools, libraries, and integrated commercial components. Identify the data items or messages coming into the system and going out and describe the purpose of each. Describe the services needed and the nature of communications. Refer to documents that describe detailed application programming interface protocols. Identify data that will be shared across software components. If the data sharing mechanism must be implemented in a specific way (for example, use of a global data area in a multitasking operating system), specify this as an implementation constraint.

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
* NFR0: The system will allow the user to create an account in less than 3 minutes.
* NFR1: The system will allow the user to create a listing in less than 6 minutes.

----------------
If there are performance requirements for the product under various circumstances, state them here and explain their rationale, to help the developers understand the intent and make suitable design choices. Specify the timing relationships for real time systems. Make such requirements as specific as possible. You may need to state performance requirements for individual functional requirements or features.

#### 3.2.2 Security
* NFR2: The system will not allow non-registered users see other user's profile information.

--------------
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
* NFR3: The system will be available 24/7. It will use a reliable hosting provider to handle periods of high traffic.

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
* NFR4: The total cost for development and initial deployment of the software product is estimated at $50,000. This includes costs for development tools, hosting, and human resources.

#### 3.2.7 Deadline
* NFR5: The software product is scheduled for delivery and deployment on 12/11/2025.