CREATE TABLE product (
    id                      BIGINT PRIMARY KEY,
    name                    VARCHAR(255) NOT NULL,
    description             VARCHAR(255) NOT NULL,
    kcal                    BIGINT NOT NULL
);

CREATE TABLE list (
    id                      BIGINT PRIMARY KEY,
    name                    VARCHAR(255) NOT NULL
);