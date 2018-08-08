create table category (product_category varchar(20),no_of_products int,primary key(product_category));
create table products(product_guid int,name varchar(20),image varchar(20),description varchar(30),price int,product_category varchar(20),primary key(product_guid), foreign key (product_category) references category(product_category));
create table customer(customer_guid int,username varchar(20),password varchar(20),registration_date varchar(20),primary key(customer_guid));
create table product_order(order_id int,customer_guid int,no_of_items int,order_date varchar(20),primary key(order_id),foreign key(customer_guid) references customer(customer_guid));
create table lineitems(lineitem_guid int,product_guid int,order_guid int,quantity int,primary key(lineitem_guid));
create table organization(name varchar(20),address varchar(20),contact varchar(20),email varchar(20));

select * from category;
select * from products;
select * from customer;
select * from product_order;
select * from lineitems;
select * from organization;
delete from category;
insert into category values('mobiles',3);
insert into category values('laptops',4);
insert into category values('bags',3);


delete from cart;
delete from lineitems;
delete from product_order;
select * from products;
select * from lineitems;
select * from product_order;
select * from cart;
select * from customer;
drop table cart;
alter table cart add column customer_guid int;
create table cart(no int,name varchar(20),price int,qty int,totalPrice int,category varchar(20),product_guid int,customer_guid int,primary key(no),foreign key(customer_guid) references customer(customer_guid),foreign key(product_guid) references products(product_guid));
