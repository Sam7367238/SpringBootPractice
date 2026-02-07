create table products
(
    id    int auto_increment
        primary key,
    name  varchar(255)  not null,
    price DECIMAL(9, 2) not null
);

