DROP TABLE IF EXISTS `trainer` CASCADE;

CREATE TABLE `trainer` (
 	 `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
 	 `username` VARCHAR(60) NOT NULL,
 	 `first_name` VARCHAR(60) NOT NULL,
 	 `last_name` VARCHAR(60) NOT NULL,
 	 `password` VARCHAR(45) NOT NULL,
 	 `field` VARCHAR(60) NOT NULL,
 	 `trainer_email` VARCHAR(60) NOT NULL
);