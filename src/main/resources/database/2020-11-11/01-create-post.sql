--liquibase formatted sql
--changeset kwojtas:1
create Table POST
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(400)  NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP,
    modified TIMESTAMP
);