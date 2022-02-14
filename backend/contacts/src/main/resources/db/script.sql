CREATE SCHEMA `contact`;

CREATE TABLE `contact`.`category` (id bigint not null auto_increment, category_type varchar(255) not null, primary key (id));
CREATE TABLE `contact`.`user` (id bigint not null auto_increment, first_name varchar(255) not null, last_name varchar(255) not null, email varchar(255) not null,
                        phone_number varchar(255) not null, category_id bigint, primary key (id));

INSERT INTO `contact`.`category` (`id`, `category`) VALUES
    (1, 'FAMILY'), (2, 'FRIEND'), (3, 'WORK'), (4, 'ACQUAINTANCE'), (5, 'OTHER');

INSERT INTO `contact`.`user` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `category_id`, notes) VALUES
    (1, 'Jhon', 'Doe', 'jhondoe@gmail.com', '434335353', 1, NULL),
    (2, 'Martin', 'Scotfield', 's_martin@gmail.com' ,'4343434', 2, NULL),
    (3, 'Ana', 'Sein', 'seinannacollege@gmail.com', '434335353', 2, NULL),
    (4, 'Lucia', 'Carlson', 'lucia_carlson_99@gmail.com' ,'4343434', 4, NULL),
    (5, 'Connor', 'Perez', 'afz@gmail.com', '434335353', 5, NULL),
    (6, 'Martin', 'Triangle', 'martin_trange_96@gmail.com' ,'4343434', 4, NULL),
    (7, 'Juan', 'Chim', 'jritne@gmail.com', '434335353', 5, NULL),
    (8, 'Carlos', 'Memento', 'smaritn__v2@gmail.com' ,'4343434', 2, NULL),
    (9, 'Jhon', 'Doe', 'doejhon929_2323@gmail.com', '434335353', 1, NULL),
    (10, 'Ana', 'Scotfield', 'annascotf@gmail.com' ,'4343434', 2, NULL),
    (11, 'Ana', 'Doe', 'bettercallanna@gmail.com', '434335353', 1, NULL),
    (12, 'Jhon', 'Buterin', 'carlsonbusiness@gmail.com' ,'4343434', 1, NULL),
    (13, 'Connor', 'Perez', 'theend@gmail.com', '434335353', NULL, NULL),
    (14, 'Martin', 'Trange', 'trangemartin@gmail.com' ,'4343434', NULL, NULL),
    (15, 'Satoshi', 'Nakamoto', 'satoshi@gmail.com', '434335353', NULL, NULL),
    (16, 'Donna', 'Sein', 'donnasein@gmail.com' ,'4343434', NULL, NULL);