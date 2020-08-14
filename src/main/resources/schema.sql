DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    account_number INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    address VARCHAR(250),
    username VARCHAR(250),
    password VARCHAR(250)
);
