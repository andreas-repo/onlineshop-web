DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
                         id SERIAL PRIMARY KEY,
                         email VARCHAR(40) NOT NULL UNIQUE,
                         password VARCHAR(10) NOT NULL CHECK (LENGTH(password) >= 6)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON customer TO demo;

CREATE UNIQUE INDEX customer_index ON customer(email, password);

CREATE TABLE item(
                     id SERIAL PRIMARY KEY,
                     title VARCHAR(40) NOT NULL,
                     description VARCHAR(1000) NOT NULL,
                     price INTEGER NOT NULL,
                     photo BYTEA,
                     seller_id INTEGER NOT NULL,
                     buyer_id INTEGER,
                     sold TIMESTAMP,
                     CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES customer(id),
                     CONSTRAINT fk_buyer FOREIGN KEY (buyer_id) REFERENCES customer(id)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON item TO demo;

DROP SEQUENCE IF EXISTS seq_customer;
CREATE SEQUENCE seq_customer;
GRANT ALL ON seq_customer TO demo;

DROP SEQUENCE IF EXISTS seq_item;
CREATE SEQUENCE seq_item;
GRANT ALL ON seq_item TO demo;

commit;