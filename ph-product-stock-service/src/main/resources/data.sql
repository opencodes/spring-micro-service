--DROP TABLE IF EXISTS product_stock;
--CREATE TABLE PRODUCT_STOCK (
--  id INT PRIMARY KEY,
--  product_name VARCHAR(250) NOT NULL,
--  product_price INT NOT NULL,
--  product_availability VARCHAR(250) NOT NULL,
--  product_discountoffer INT NOT NULL
--);
insert into PRODUCT_STOCK(id, product_name, product_price, product_availability, product_discountoffer) values(1001,'bat',5000,'yes',20);
insert into PRODUCT_STOCK(id, product_name, product_price, product_availability, product_discountoffer) values(1002,'ball',500,'yes',40);
insert into PRODUCT_STOCK(id, product_name, product_price, product_availability, product_discountoffer) values(1003,'helmet',3000,'yes',30);