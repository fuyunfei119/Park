CREATE DATABASE IF NOT EXISTS `parking`;
USE `parking`;

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
    `id` varchar (50) NOT NULL,
    `name` varchar (25),
    `modell` varchar (10)
);

INSERT INTO  `car` VALUES ('900b267b-171d-4932-8796-f5d945e72432','Test_One','Benz');
INSERT INTO  `car` VALUES ('d7818412-eec2-433c-a598-d58c586a82ad','Test_Two','BMW');
INSERT INTO  `car` VALUES ('15c265cb-2192-4c7c-aff3-220fa938937d','Test_Three','VW');

