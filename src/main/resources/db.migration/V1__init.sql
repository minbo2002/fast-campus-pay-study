drop table if exists users;

create table users (
    id bigint auto_increment,
    username varchar(255) not null unique,
    password varchar(255) not null,
    amount int not null,
    role_type ENUM('ADMIN','SELLER','USER') NOT NULL,
    created_at timestamp not null default now(),
    last_updated_at timestamp null default now(),
    primary key (id)
);