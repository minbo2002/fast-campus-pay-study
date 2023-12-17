drop table if exists stores;

create table stores (
    id bigint auto_increment,
    name varchar(255) not null,
    location varchar(255) not null,
    created_at timestamp not null default now(),
    last_updated_at timestamp null default now(),
    primary key (id)
);