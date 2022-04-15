CREATE TABLE IF NOT EXISTS admin
(
    id       SERIAL,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(500) NOT NULL,
    CONSTRAINT admin_pkey PRIMARY KEY (id),
    CONSTRAINT admin_login_ukey UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS type
(
    id   SERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT type_pkey PRIMARY KEY (id),
    CONSTRAINT type_name_ukey UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product
(
    id          SERIAL,
    article     INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL,
    price       INT          NOT NULL,
    height      REAL         NOT NULL,
    width       REAL         NOT NULL,
    deep        REAL         NOT NULL,
    type_id     BIGINT       NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT product_article_ukey UNIQUE (article),
    CONSTRAINT product_type_fkey FOREIGN KEY (type_id) REFERENCES type (id)
);

CREATE TABLE IF NOT EXISTS product_image
(
    id          SERIAL,
    path        TEXT        NOT NULL,
    name        UUID        NOT NULL DEFAULT GEN_RANDOM_UUID(),
    extension   VARCHAR(25) NOT NULL,
    order_index INT         NOT NULL DEFAULT 0,
    product_id  BIGINT      NOT NULL,
    CONSTRAINT product_image_pkey PRIMARY KEY (id),
    CONSTRAINT product_image_product_fkey FOREIGN KEY (product_id) REFERENCES product (id)
);

INSERT INTO admin(login, password)
VALUES ('login', 'password');

INSERT INTO type(name)
VALUES ('Дивани'),
       ('Крісла'),
       ('Ліжка'),
       ('Модульні системи'),
       ('Інше');
