--liquibase formatted sql
--changeset kwojtas:4
create table users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(50)  not null UNIQUE,
    password varchar(100) not null,
    enabled  boolean      not null
);
--changeset kwojtas:5
create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references
        users (username),
    UNIQUE KEY username_authority (username, authority)
);
--changeset kwojtas:6
insert into users (id, username, password, enabled)
values (1, 'string', '{bcrypt}$2a$10$WJpeq/RTg5w/K.fhJOEV8uQAYaS0dSQ5W6nu87gOZ478mO6VGHBnO', true);
insert into authorities (username, authority)
values ('string', 'USER');
