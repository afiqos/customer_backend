DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    account_number INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    address VARCHAR(250) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);
