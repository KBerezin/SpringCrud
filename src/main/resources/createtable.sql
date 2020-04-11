CREATE TABLE USERS
(
    id          bigint auto_increment,
    username    varchar(256) not null,
    password    varchar(256) not null,
    first_name  varchar(256) not null,
    second_name varchar(256) not null,
    birthday    date         not null,
    PRIMARY KEY (id),
    UNIQUE KEY (id),
    UNIQUE KEY (username)
) DEFAULT CHARSET = utf8;

CREATE TABLE roles
(
    id   bigint NOT NULL AUTO_INCREMENT,
    role varchar(256) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (id),
    UNIQUE KEY (role)
) DEFAULT CHARSET = utf8;

CREATE TABLE users_roles
(
    user_id bigint,
    role_id bigint,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) DEFAULT CHARSET = utf8;

INSERT INTO USERS (id, username, password, first_name, second_name, birthday)
VALUES (1,
        'admin',
        'admin',
        'admin',
        'admin',
        '1999-01-01');

INSERT INTO USERS (id, username, password, first_name, second_name, birthday)
VALUES (2,
        'ivan',
        '123',
        'Ivan',
        'Petrov',
        '2000-02-02');

INSERT INTO roles (id, role)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO users_roles (USER_ID, ROLE_ID)
VALUES (1, 1),
       (1, 2),
       (2, 2);