--liquibase formatted sql
--changeset kwojtas:2
create Table POST
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT        NOT NULL,
    title   VARCHAR(400)  NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP,
    modified TIMESTAMP
);

Alter Table POST
    Add CONSTRAINT user_post_id
        FOREIGN KEY (user_id) REFERENCES USER (id);
