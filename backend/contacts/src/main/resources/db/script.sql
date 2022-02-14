        CREATE SCHEMA `contact`;

        CREATE TABLE `contact`.`category` (id bigint not null auto_increment, category_type varchar(255) not null, primary key (id));
        CREATE TABLE `contact`.`user` (id bigint not null auto_increment, first_name varchar(255) not null, last_name varchar(255) not null, email varchar(255) not null,
                                phone_number varchar(255) not null, category_id bigint, primary key (id));

        INSERT INTO `contact`.`category` (`id`, `category_type`) VALUES
            (1, 'FAMILY'), (2, 'FRIEND'), (3, 'ACQUAINTANCE') , (4, 'OTHER');

        INSERT INTO `contact`.`user` (`id`, `first_name`, `last_name`, `email`, `phone_number`) VALUES
            (1, 'Jhon', 'Doe', 'jhondoe@gmail.com', '434335353'),
            (2, 'Martin', 'Scotfield', 'smaritn@gmail.com' ,'4343434'),
            (3, 'Ana', 'Doe', 'jhondoe@gmail.com', '434335353'),
            (4, 'Lucia', 'Carlson', 'smaritn@gmail.com' ,'4343434'),
            (5, 'Connor', 'Perez', 'jhondoe@gmail.com', '434335353'),
            (6, 'Martin', 'Trange', 'smaritn@gmail.com' ,'4343434'),
            (7, 'Juan', 'Chim', 'jhondoe@gmail.com', '434335353'),
            (8, 'Donna', 'Sein', 'smaritn@gmail.com' ,'4343434');