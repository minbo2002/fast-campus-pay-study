drop table if exists fastcampus.users;

create table fastcampus.users (
    id bigint auto_increment,
    username varchar(255) not null unique,
    password varchar(255) not null,
    amount int not null,
    role_type ENUM('ADMIN','SELLER','USER') NOT NULL,
    created_at timestamp not null default now(),
    last_updated_at timestamp null default now(),
    primary key (id)
);

drop table if exists fastcampus.stores;

create table stores (
                        id bigint auto_increment,
                        name varchar(255) not null,
                        location varchar(255) not null,
                        created_at timestamp not null default now(),
                        last_updated_at timestamp null default now(),
                        primary key (id)
);

drop table if exists fastcampus.payments;

CREATE TABLE payments (
                          id bigint not null auto_increment,
                          store_id bigint not null,
                          user_id bigint not null,
                          price int NOT NULL,
                          payment_type ENUM('COMPLETE','REQUEST') NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          last_updated_at TIMESTAMP NULL DEFAULT NULL,
                          PRIMARY KEY (id)
);

ALTER TABLE payments
    ADD CONSTRAINT fk_store_id
        FOREIGN KEY (store_id) REFERENCES stores(id);

ALTER TABLE payments
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES users(id);
