--liquibase formatted sql
--changeset kwojtas:1
create Table USER
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(2000) NULL,
    second_name VARCHAR(2000) NULL,
    surname     VARCHAR(2000) NULL,
    created     TIMESTAMP,
    modified    TIMESTAMP
);
