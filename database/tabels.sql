--CREATE DATABASE shop_repository encoding ='UTF8';

CREATE SCHEMA shop_storage;

SET SEARCH_PATH = "shop_repository";

CREATE TABLE shop_storage.employee_storage(
  employee_id BIGSERIAL PRIMARY KEY NOT NULL ,
  first_name VARCHAR(128) NOT NULL ,
  last_name VARCHAR(128)NOT NULL ,
  gender VARCHAR(12)NOT NULL ,
  date_of_birth DATE,
  phone_number VARCHAR(12) UNIQUE NOT NULL ,
  position VARCHAR(12)
);
DROP TABLE employee_storage;

CREATE TABLE shop_storage.address(
    id BIGSERIAL PRIMARY KEY NOT NULL ,
    city      VARCHAR(128) NOT NULL,
    street    VARCHAR(128) NOT NULL,
    house     VARCHAR(4) NOT NULL,
    apartment VARCHAR(8) NOT NULL
);

DROP TABLE shop_storage.address;

CREATE TABLE shop_storage.product(
  product_id BIGSERIAL PRIMARY KEY NOT NULL ,
  name VARCHAR(512) NOT NULL ,
  size VARCHAR(4) NOT NULL,
  season VARCHAR(12) NOT NULL,
  type VARCHAR(128) NOT NULL
);

DROP TABLE shop_storage.product;

CREATE TABLE shop_storage.customer_storage(
  id BIGSERIAL PRIMARY KEY NOT NULL ,
  first_name VARCHAR(128) NOT NULL ,
  last_name VARCHAR(128)NOT NULL ,
  gender VARCHAR(12)NOT NULL ,
  date_of_birth DATE,
  phone_number VARCHAR(12) UNIQUE NOT NULL ,
  email VARCHAR(128) UNIQUE NOT NULL ,
  order_number BIGSERIAL UNIQUE NOT NULL ,
  address VARCHAR(256) REFERENCES shop_storage.address (id, city, street, house, apartment)
);

DROP TABLE customer_storage;

CREATE TABLE shop_storage.orders(
  order_id BIGSERIAL PRIMARY KEY NOT NULL,
  customer_id BIGINT NOT NULL REFERENCES shop_storage.customer_storage (id) ON DELETE CASCADE ON UPDATE CASCADE,
  order_date DATE,
  delivery_method VARCHAR(128),
  payment_method VARCHAR (64),
  order_cost DOUBLE PRECISION,
  order_status VARCHAR (64)
);

DROP TABLE shop_storage.orders;

CREATE TABLE shop_storage.shopping_cart(
  id BIGSERIAL PRIMARY KEY,
  product_name VARCHAR(512) REFERENCES shop_storage.product (name),
  amount BIGINT NOT NULL,
  cost DOUBLE PRECISION NOT NULL
);

DROP TABLE shop_storage.shopping_cart;

CREATE TABLE shop_storage.stock(
  product_id BIGSERIAL PRIMARY KEY NOT NULL REFERENCES shop_storage.product (product_id),
  amount_left BIGINT
);

DROP TABLE shop_storage.stock;

