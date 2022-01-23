CREATE TABLE IF NOT EXISTS category(
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY(id),
    CONSTRAINT category_name_ukay UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS product(
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    short_description VARCHAR(255) NOT NULL,
    full_description TEXT NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS product_image(
    product_id BIGINT,
    product_image BYTEA NOT NULL,
    product_image_index INT NOT NULL DEFAULT 0,
    CONSTRAINT product_image_pkey PRIMARY KEY(product_id, product_image_index),
    CONSTRAINT product_image_fkey FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS category_product(
    category_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT category_product_pkey PRIMARY KEY(category_id, product_id),
    CONSTRAINT category_product_category_fkey FOREIGN KEY(category_id) REFERENCES category(id),
    CONSTRAINT category_product_product_fkey FOREIGN KEY(product_id) REFERENCES product(id)
);
