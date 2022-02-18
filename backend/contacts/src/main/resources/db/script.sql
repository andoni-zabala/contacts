CREATE SCHEMA `contact`;

CREATE TABLE `contact`.`category` (id bigint not null auto_increment, category varchar(255) not null, primary key (id));

CREATE TABLE `contact`.`user` (id bigint not null auto_increment, first_name varchar(255) not null, last_name varchar(255) not null, email varchar(255) not null,
                        phone_number varchar(255) not null, category_id bigint, primary key (id));

CREATE TABLE `contact`.`change_history` (id bigint not null auto_increment, date datetime, field varchar(255), new_value varchar(255),
                                        old_value varchar(255), performed_by varchar(255), user_id bigint, primary key (id));

CREATE TABLE `contact`.`user_changes_history` (user_id bigint not null, changes_history_id bigint not null);

INSERT INTO `contact`.`category` (`id`, `category`) VALUES
    (1, 'FAMILY'), (2, 'FRIEND'), (3, 'WORK'), (4, 'ACQUAINTANCE'), (5, 'OTHER');

INSERT INTO `contact`.`user` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `category_id`) VALUES
    (1, 'Jhon', 'Doe', 'jhondoe@gmail.com', '652048213', 1),
    (2, 'Martin', 'Scotfield', 's_martin@gmail.com' ,'771881340', 2),
    (3, 'Ana', 'Sein', 'seinannacollege@gmail.com', '632959626', 2),
    (4, 'Lucia', 'Carlson', 'lucia_carlson_99@gmail.com' ,'753086967', 4),
    (5, 'Connor', 'Perez', 'afz@gmail.com', '754177354', 5),
    (6, 'Martin', 'Triangle', 'martin_trange_96@gmail.com' ,'689639903', 4),
    (7, 'Juan', 'Chim', 'jritne@gmail.com', '689059903', 5),
    (8, 'Carlos', 'Memento', 'smaritn__v2@gmail.com' ,'684789903', 2),
    (9, 'Jhon', 'Doe', 'doejhon929_2323@gmail.com', '689059903', 1),
    (10, 'Ana', 'Scotfield', 'annascotf@gmail.com' ,'627899903', 2),
    (11, 'Ana', 'Doe', 'bettercallanna@gmail.com', '624576903', 1),
    (12, 'Jhon', 'Buterin', 'carlsonbusiness@gmail.com' ,'633339903', 1),
    (13, 'Connor', 'Perez', 'theend@gmail.com', '684356903', NULL),
    (14, 'Martin', 'Husqvarna', 'trangemartin@gmail.com' ,'6432103', NULL),
    (15, 'Satoshi', 'Nakamoto', 'satoshi@gmail.com', '683569903', NULL),
    (16, 'Donna', 'Scotter', 'donscotter@gmail.com' ,'670219903', NULL),
    (17, 'Ludmila', 'Paecella', 'pacella34_luciana@gmail.com', '617929903', 1),
    (18, 'Luciana', 'Soler', 'solluciana_martin@gmail.com' ,'689059903', 2),
    (19, 'Annabella', 'Sein', 'senAnnabell@gmail.com', '63213903', 2),
    (20, 'Bruno', 'Gomez', '23brunogomez3@gmail.com' ,'68234503', 4),
    (21, 'Juan', 'Soler', 'solerjuan21@gmail.com', '687432903', 5),
    (22, 'Martin', 'Policella', 'martin_policella_96@gmail.com' ,'670989903', 4),
    (23, 'Elizabeth', 'Policella', 'polieliza@gmail.com', '68934203', 5),
    (24, 'Mauro', 'Averza', 'averza__v2@gmail.com' ,'61259903', 2),
    (25, 'Ignacio', 'Ciarlante', 'ciarlante_ign@gmail.com', '796361512', 1),
    (26, 'Fernando', 'Scotfield', 'fernando_scotfield@gmail.com' ,'786368512', 2),
    (27, 'Beatriz', 'Doe', 'doebetty@gmail.com', '786368512', 1),
    (28, 'Brian', 'Beitia', 'beitiabrian@gmail.com' ,'611688343', 1),
    (29, 'Angel', 'Felix', 'felixangel@gmail.com', '611688123', NULL),
    (30, 'Luciano', 'Zabala', 'zabala_123123@gmail.com' ,'611688471', NULL),
    (31, 'Martin', 'Nakamoto', 'mr_nobody@gmail.com', '434335353', NULL),
    (32, 'Juan', 'Bruno', 'bruno_juan9888@gmail.com' ,'749311425', NULL),
    (33, 'Angel', 'Fernandez', 'fer_angel@gmail.com', '631681442', NULL),
    (34, 'Luciano', 'Escalante', 'eluciano@gmail.com' ,'753780011', NULL),
    (35, 'Martin', 'Celia', 'celia_martin@gmail.com', '749134354', NULL);

INSERT INTO `contact`.`change_history` (`id`, `date`, `field`, `new_value`, `old_value`, `performed_by`, user_id) VALUES
    (1, '2022-01-01 13:24:10', 'firstName', 'Martin', 'Jhon', 'Thomas Carlson', 1),
    (2, '2022-01-13 18:29:10', 'lastName', 'Martin', 'Jhon', 'Thomas Carlson', 25),
    (3, '2022-01-24 21:25:10', 'lastName', 'Martin', 'Jhon', 'Thomas Carlson', 1),
    (4, '2022-01-25 23:24:10', 'lastName', 'Elizabeth', 'Ludmila', 'Brian Beitia', 2),
    (5, '2022-01-01 13:24:10', 'firstName', 'Connor', 'Jhon', 'Satoshi Nakamoto', 3),
    (6, '2022-01-13 18:29:10', 'firstName', 'Martin', 'Jhon', 'Annabella Sein', 1),
    (7, '2022-01-24 21:25:10', 'firstName', 'Martin', 'Jhon', 'Thomas Carlson', 7),
    (8, '2022-01-25 23:24:10', 'email', 'Martin', 'Jhon', 'Thomas Carlson', 8),
    (9, '2022-01-01 13:24:10', 'email', 'Martin', 'Jhon', 'Elizabeth Policella', 7),
    (10, '2022-01-13 18:29:10', 'phoneNumber', 'Martin', 'Jhon', 'Thomas Carlson', 4),
    (11, '2022-01-24 21:25:10', 'phoneNumber', 'Martin', 'Jhon', 'Juan Bruno', 5),
    (12, '2022-01-25 23:24:10', 'phoneNumber', 'Martin', 'Jhon', 'Juan Bruno', 2);