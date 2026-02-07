create table users
(
    id       int auto_increment primary key,
    username varchar(255) not null unique
);

alter table products
    add user_id int not null;

alter table products
    add constraint products_users_id_fk
        foreign key (user_id) references users (id);