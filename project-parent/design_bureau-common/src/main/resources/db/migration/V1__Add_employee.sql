CREATE TABLE role
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    role_name varchar(20) NOT NULL
);

INSERT INTO role(role_name)
VALUES ('ADMIN'),
       ('USER');

CREATE TABLE employees
(
    id          BIGINT       AUTO_INCREMENT,
    first_name  VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    last_name   VARCHAR(255) NOT NULL,
    position_in_company       VARCHAR(50),
    phone       VARCHAR(150),
    login       VARCHAR(150) NOT NULL UNIQUE,
    password  VARCHAR(150) NOT NULL,
    salt      varchar(50)  NOT NULL,
    role_id   int          NOT NULL DEFAULT 2,
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT role_fk FOREIGN KEY (role_id)
        REFERENCES role (id)
        ON DELETE CASCADE); -- При удалении роли удалятся все записи зависящие от ключа. --

ALTER TABLE employees
    AUTO_INCREMENT = 100;

INSERT INTO employees (id, first_name, middle_name, last_name, position_in_company, phone, login, password, salt, role_id)
VALUES (1, 'Ivan', 'Ivanovich', 'Ivanov', 'engineer', 'null', 'Ivan88', '66af913e3de092f2ea078df5221cd690a82d8c725a8432b56f2cc20583fec399',
        '7nQKT9S3lDdvtCzFnLZY7Q9Y6D0=', 1),
       (2, 'Petr', 'Petrovich', 'Petrov', 'engineer', 'null', 'Pety90', '1484b4a2dbca360916739127b590705e31f94bb5622087bda717f3c3560d66a8',
        'Ai2USpkbSIgwS2Z/w39xmzVUzmo=', 2);