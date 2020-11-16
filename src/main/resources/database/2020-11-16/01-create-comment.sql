--liquibase formatted sql
--changeset kwojtas:1
create Table COMMENT
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT        NOT NULL,
    content VARCHAR(2000) NULL,
    created TIMESTAMP,
    modified TIMESTAMP
);

Alter Table COMMENT
    Add CONSTRAINT comment_post_id
        FOREIGN KEY (post_id) REFERENCES POST (id);