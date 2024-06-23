## American Boutique (Online Clothes Shop)
Welcome to the American Boutique, an online clothes shop designed to provide a seamless shopping experience. This project leverages a microservices architecture to ensure scalability, flexibility, and maintainability. The application is developed using Java Spring Boot and interacts with a MySQL database. It exposes a RESTful API for interaction with various services.

### Modules 
The project is divided into the following microservices:
- product-service
- user-service
- shoppingbag-service
- order-service
- characteristics-service
- discovery-server
- api-gateway

### Services Overview #user-service Purpose:
The user-service manages user information including user profiles and roles.
- Endpoint: /allusers
- Method: GET
- Description: Retrieve a list of all users in the system.

The product-service manages the products available in the store.
- Endpoint: /product
- Method: GET
- Description: Retrieve a list of all products available in the store.

- Endpoint: /product
- Method: POST
- Description: Add a new product to the store.

- Endpoint: /product/{id}
- Method: DELETE
- Description: Delete a product by its ID.

- Endpoint: /product/{id}
- Method: PUT
- Description: Updates an existing product by its ID.

The order-service handles customer orders and order management.
- Endpoint: /allorders
- Method: GET
- Description: Retrieve a list of all orders placed.

- Endpoint: /orderlist
- Method: GET
- Description: Retrieve a list of products in the current order. Response JSON:

- Endpoint: /orderlist/{id}
- Method: GET
- Description: Retrieve a list of products for a specific order by order ID.

- Endpoint: /orderlist1/{username}
- Method: GET
- Description: Retrieve a list of products for a specific order by username.

The characteristics-service manages the various characteristics of products, such as color, size, and state.
- ColorController: Manages product colors.
- ProductController: Manages product-specific characteristics.
- SizeController: Manages product sizes.
- StateController: Manages states relevant to products (e.g., new, used). 
 
Each controller in the characteristics-service handles CRUD operations (Create, Read, Update, Delete) for their respective characteristics, ensuring products have accurate and up-to-date attribute information.

### How to Run:
Clone the repository. Set up the MySQL database and update the configuration in each service's application properties file. Use Maven to build each service. Start the discovery server. Start the API gateway. Start each microservice (product-service, user-service, shoppingbag-service, order-service, characteristics-service). Access the services through the API gateway.

### Conclusion:
The American Boutique project is a robust and scalable online shopping platform built with modern technologies. By using a microservices architecture, we ensure that the application can grow and adapt to future needs seamlessly.

### Technology Stack:
- **Java Spring Boot:** For building the microservices.
- **Microservices Architecture:** To separate concerns and allow independent deployment and scaling.
- **RESTful API:** For communication between services.
- **Lombok:** For reducing boilerplate code.
- **Spring Boot Starter Web:** For building web applications.
  **Spring Boot Starter Data JPA:** For data persistence.
- **Spring Boot Starter Test:** For testing purposes.
- **Spring Boot Starter Actuator:** For monitoring and managing the application.
- **Spring Cloud Netflix Eureka Client:** For service discovery.
- **Spring Cloud Netflix Eureka Server:** For service discovery.
- **Spring Cloud Gateway:** For building API gateways.
- **Spring Cloud Netflix Eureka Client:** For service discovery.
- **MySQL Connector:** For connecting to the MySQL database.

### Contributors
- Abubaker Ashaipi
