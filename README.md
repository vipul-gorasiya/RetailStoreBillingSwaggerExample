# vipulretailstore

## Technologies Used:
* Swagger - API speicifcation and Initial Stub generation
* Spring-boot - Rest, Web, JPA and Test implementation
* H2 - database
* Maven - build tool
* Java 8

## Products
*  GET /product/{productId} - get Product - to be used when product is scanned

## Bill
*  POST /bill - create bill
*  PUT /bill - complete bill
*  PUT /bill/{productId} - add product to bill
*  DELETE /bill/{productId} - remove product from bill

## Models
* Bill
* Bill Item
* Product

## How to run the project
1. Import as maven project
2. Run as typical spring-boot project.(mvn spring-boot:run)

## Insert initial product data
1. after running application launch http://localhost:808/h2-console
2. run data.sql present in project 
3. test http://localhost:808/rs/product/1 to see product data inserted

## Test
* Sample test has been provided for Product Rest controller.

## Generating client
* 'api.yaml' in main project is API specifications which can be used to generate client API using swagger code-gen 
