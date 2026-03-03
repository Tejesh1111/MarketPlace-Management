E-Commerce Backend (Spring Boot)

A fully functional E-Commerce Backend API built using Spring Boot, JPA, Hibernate, and MySQL.
<br/>
<br/>
This project implements core e-commerce features including:
<br/>
User Registration
<br/>
Category Management
<br/>
Product Management
<br/>
Cart System
<br/>
Order Placement
<br/>
Payment Processing
<br/>
Global Exception Handling
<br/>
DTO-based API responses
<br/>





Tech Stack
<br/>
Java 17+
<br/>
Spring Boot
<br/>
Spring Data JPA
<br/>
Hibernate
<br/>
MySQL
<br/>
Maven
<br/>
REST APIs
<br/>
DTO Architecture



📁 Project Structure
<br/>
com.example.Backend
<br/>
│
<br/>
├── controller
<br/>
├── service
<br/>
├── repository
<br/>
├── entity
<br/>
├── dto
<br/>
├── exception
<br/>
└── BackendApplication.java





FEATURES IMPLEMENTED 

👤 User Module
<br/>
Register user
<br/>
Get all users
<br/>
Get user by ID
<br/>
Duplicate email validation
<br/>
Default role assignment (USER)

📂 Category Module
<br/>
Create category
<br/>
Unique category validation
<br/>
Get all categories

📦 Product Module
<br/>
Create product under category
<br/>
Get all products
<br/>
Get product by ID
<br/>
ProductDTO implementation

🛒 Cart Module
<br/>
Add product to cart
<br/>
Increase quantity if already exists
<br/>
View cart with total calculation
<br/>
Remove cart item
<br/>
CartDTO & CartItemDTO implementation

📦 Order Module
<br/>
Place order from cart
<br/>
Stock validation
<br/>
Order items creation
<br/>
Cart auto-clear after order
<br/>
OrderDTO implementation
<br/>

💳 Payment Module
<br/>
Make payment for order
<br/>
Order status update (PLACED → PAID)
<br/>
Prevent double payment
<br/>
PaymentDTO implementation
<br/>

⚠️ Global Exception Handling
<br/>
ResourceNotFoundException
<br/>
DuplicateResourceException
<br/>
CartEmptyException
<br/>
Centralized error response structure




API Endpoints
<br/>
Users
<br/>
POST
/api/users/register
<br/>
GET 
/api/users
<br/>
GET  
/api/users/{id}


Categories
<br/>
POST   /api/categories
<br/>
GET    /api/categories


Products
<br/>
POST   /api/products/{categoryId}
<br/>
GET    /api/products
<br/>
GET    /api/products/{id}


cart
<br/>
POST   /api/cart/add?userId=&productId=&quantity=
<br/>
GET    /api/cart/{userId}
<br/>
DELETE /api/cart/remove/{cartItemId}


Orders
<br/>
POST   /api/orders/place/{userId}
<br/>
GET    /api/orders/user/{userId}


Payments
<br/>
POST   /api/payments/{orderId}?method=UPI





ARCHITECTURE HIGHLIGHTS
<br/>
Proper Layered Architecture (Controller → Service → Repository)
<br/>
DTO Pattern used to avoid exposing Entities
<br/>
Validation handled at service layer
<br/>
Business logic separated from controllers
<br/>
Clean exception structure
<br/>
Stock management implemented
<br/>
Cart to Order conversion logic implemented





Database Tables
<br/>
users
<br/>
categories
<br/>
products
<br/>
carts
<br/>
cart_items
<br/>
orders
<br/>
order_items
<br/>
payments




▶️ How To Run
<br/>
1. Clone Repository
<br/>
git clone <your-repo-url>


2. Configure MySQL in application.properties
<br/>
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
<br/>
spring.datasource.username=root
<br/>
spring.datasource.password=your_password
<br/>
spring.jpa.hibernate.ddl-auto=update
<br/>

3.Run the application
<br/>
mvn spring-boot:run
<br/>

4.Server runs on:
<br/>
http://localhost:8080





Current Status
<br/>
Core E-Commerce Backend Flow is fully functional:
<br/>
User → Cart → Order → Payment
