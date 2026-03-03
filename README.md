E-Commerce Backend (Spring Boot)

A fully functional E-Commerce Backend API built using Spring Boot, JPA, Hibernate, and MySQL.
This project implements core e-commerce features including:
User Registration
Category Management
Product Management
Cart System
Order Placement
Payment Processing
Global Exception Handling
DTO-based API responses





Tech Stack
Java 17+
Spring Boot
Spring Data JPA
Hibernate
MySQL
Maven
REST APIs
DTO Architecture




📁 Project Structure
com.example.Backend
│
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── BackendApplication.java





FEATURES IMPLEMENTED 

👤 User Module
Register user
Get all users
Get user by ID
Duplicate email validation
Default role assignment (USER)

📂 Category Module
Create category
Unique category validation
Get all categories

📦 Product Module
Create product under category
Get all products
Get product by ID
ProductDTO implementation

🛒 Cart Module
Add product to cart
Increase quantity if already exists
View cart with total calculation
Remove cart item
CartDTO & CartItemDTO implementation

📦 Order Module
Place order from cart
Stock validation
Order items creation
Cart auto-clear after order
OrderDTO implementation

💳 Payment Module
Make payment for order
Order status update (PLACED → PAID)
Prevent double payment
PaymentDTO implementation

⚠️ Global Exception Handling
ResourceNotFoundException
DuplicateResourceException
CartEmptyException
Centralized error response structure




API Endpoints

Users
POST   /api/users/register
GET    /api/users
GET    /api/users/{id}


Categories
POST   /api/categories
GET    /api/categories


Products
POST   /api/products/{categoryId}
GET    /api/products
GET    /api/products/{id}


cart
POST   /api/cart/add?userId=&productId=&quantity=
GET    /api/cart/{userId}
DELETE /api/cart/remove/{cartItemId}


Orders
POST   /api/orders/place/{userId}
GET    /api/orders/user/{userId}


Payments
POST   /api/payments/{orderId}?method=UPI





ARCHITECTURE HIGHLIGHTS

Proper Layered Architecture (Controller → Service → Repository)
DTO Pattern used to avoid exposing Entities
Validation handled at service layer
Business logic separated from controllers
Clean exception structure
Stock management implemented
Cart to Order conversion logic implemented





Database Tables

users
categories
products
carts
cart_items
orders
order_items
payments




▶️ How To Run

1. Clone Repository
git clone <your-repo-url>


2. Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


3.Run the application
mvn spring-boot:run


4.Server runs on:
http://localhost:8080





Current Status

Core E-Commerce Backend Flow is fully functional:

User → Cart → Order → Payment
