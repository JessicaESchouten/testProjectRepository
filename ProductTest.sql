DROP SCHEMA IF EXISTS productTest;
CREATE SCHEMA productTest;
USE productTest;

CREATE TABLE Product (
    productName VARCHAR(45) PRIMARY KEY,
    price double
);

CREATE USER 'userTestProduct'@'localhost' IDENTIFIED BY 'leukWachtwoord';
GRANT ALL PRIVILEGES ON productTest . * TO 'userTestProduct'@'localhost';
