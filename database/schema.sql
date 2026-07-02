CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       author VARCHAR(100) NOT NULL,
                       category VARCHAR(50) NOT NULL,
                       price DECIMAL(10,2) NOT NULL,
                       quantity INT NOT NULL
);