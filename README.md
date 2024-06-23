## American Boutique - Online Clothes Shop
#Project Overview
Welcome to the American Boutique, an online clothes shop designed to provide a seamless shopping experience. This project leverages a microservices architecture to ensure scalability, flexibility, and maintainability. The application is developed using Java Spring Boot and interacts with a MySQL database. It exposes a RESTful API for interaction with various services.

#Technology Stack
Java Spring Boot: For building the microservices.
Microservices Architecture: To separate concerns and allow independent deployment and scaling.
MySQL: As the relational database management system.
RESTful API: For communication between services.

#Modules
The project is divided into the following microservices:
product-service
user-service
shoppingbag-service
order-service
characteristics-service
discovery-server
api-gateway

#Services Overview
#user-service
Purpose: The user-service manages user information including user profiles and roles.
Endpoint: /allusers
Method: GET
Description: Retrieves a list of all users in the system.

#product-service
Purpose: The product-service manages the products available in the store.
Endpoint: /product
Method: GET
Description: Retrieves a list of all products available in the store.

Endpoint: /product
Method: POST
Description: Adds a new product to the store.

Endpoint: /product/{id}
Method: DELETE
Description: Deletes a product by its ID.

Endpoint: /product/{id}
Method: PUT
Description: Updates an existing product by its ID.

#order-service
Purpose: The order-service handles customer orders and order management.
Endpoint: /allorders
Method: GET
Description: Retrieves a list of all orders placed.

Endpoint: /orderlist
Method: GET
Description: Retrieves a list of products in the current order.
Response JSON:

Endpoint: /orderlist/{id}
Method: GET
Description: Retrieves a list of products for a specific order by order ID.


Endpoint: /orderlist1/{username}
Method: GET
Description: Retrieves a list of products for a specific order by username.

#characteristics-service
Purpose: The characteristics-service manages the various characteristics of products, such as color, size, and state.
ColorController: Manages product colors.
ProductController: Manages product-specific characteristics.
SizeController: Manages product sizes.
StateController: Manages states relevant to products (e.g., new, used).
Each controller in the characteristics-service handles CRUD operations (Create, Read, Update, Delete) for their respective characteristics, ensuring products have accurate and up-to-date attribute information.

#How to Run
Clone the repository.
Set up the MySQL database and update the configuration in each service's application properties file.
Use Maven to build each service.
Start the discovery server.
Start the API gateway.
Start each microservice (product-service, user-service, shoppingbag-service, order-service, characteristics-service).
Access the services through the API gateway.

#Conclusion
The American Boutique project is a robust and scalable online shopping platform built with modern technologies. By using a microservices architecture, we ensure that the application can grow and adapt to future needs seamlessly. This README provides a detailed overview to help you understand and run the project efficiently.
