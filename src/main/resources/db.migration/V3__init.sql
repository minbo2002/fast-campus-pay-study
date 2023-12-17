drop table if exists payments;

CREATE TABLE payments (
    id bigint not null auto_increment,
    store_id bigint not null,
    user_id bigint not null,
    price VARCHAR(255) NOT NULL,
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
