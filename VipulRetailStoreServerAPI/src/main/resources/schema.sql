DROP TABLE IF EXISTS product;
CREATE TABLE product(id INT PRIMARY KEY, name VARCHAR(255), cost number(10,2), product_category CHAR(1));
DROP TABLE IF EXISTS bill;
CREATE TABLE bill(id INT PRIMARY KEY, name VARCHAR(255), status VARCHAR(10));
DROP TABLE IF EXISTS billitem;
CREATE TABLE billitem(id INT PRIMARY KEY, billId INT, productId INT, quantity INT, 
itemCost number(10,2), itemSalesTax number(10,2), status CHAR(1));
