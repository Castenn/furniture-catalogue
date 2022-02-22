CREATE TABLE IF NOT EXISTS category
(
    id   SERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id),
    CONSTRAINT category_name_ukey UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product
(
    id                SERIAL,
    name              VARCHAR(255) NOT NULL,
    price             INT          NOT NULL,
    short_description VARCHAR(255) NOT NULL,
    full_description  TEXT         NOT NULL,
    category_id       BIGINT       NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT product_category_fkey FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS product_image
(
    id          SERIAL,
    product_id  BIGINT,
    image       BYTEA NOT NULL,
    order_index INT   NOT NULL DEFAULT 0,
    CONSTRAINT product_image_pkey PRIMARY KEY (id),
    CONSTRAINT product_image_fkey FOREIGN KEY (product_id) REFERENCES product (id)
);

INSERT INTO category(name)
VALUES ('Диваны'),
       ('Стулья'),
       ('Кровати'),
       ('Кресла'),
       ('Пуфы'),
       ('Ковры'),
       ('Столы'),
       ('Светильники');
