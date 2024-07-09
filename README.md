# Spring Boot Product Management Backend

## Overview
This project is a backend application built with Java Spring Boot that handles product management. It includes various features such as storing product details, uploading and retrieving product images, and performing CRUD operations.

## Features
- **Product Management:** Store, update, delete, and search products.
- **Image Handling:** Upload and retrieve product images.
- **Database:** Uses H2 database for storing product data.
- **RESTful API:** Implements various endpoints for interacting with the product data.
- **API Testing:** Tested using Postman.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- REST APIs
- Postman

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- Maven

### Installation
1. Clone the repository:
   ```sh
   git clone [GitHub Repository Link]
   cd [Repository Folder]
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### Get All Products
```
GET /api/products
```
Returns a list of all products.

### Get Product by ID
```
GET /api/product/{id}
```
Returns a product by its ID.

### Get Product Image by ID
```
GET /api/product/{id}/image
```
Returns the image of a product by its ID.

### Add a New Product
```
POST /api/product
```
Adds a new product. Requires `Product` and `MultipartFile` parameters.

### Update a Product
```
PUT /api/product/{id}
```
Updates an existing product. Requires `Product` and `MultipartFile` parameters.

### Delete a Product
```
DELETE /api/product/{id}
```
Deletes a product by its ID.

### Search Products
```
GET /api/products/search
```
Searches for products based on a keyword.

---

Check out the project and let me know your thoughts!

---

