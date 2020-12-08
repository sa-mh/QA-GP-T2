CREATE DATABASE IF NOT EXISTS `test`;

USE `test`;

CREATE TABLE IF NOT EXISTS `trainer` (
  `trainer_id` INTEGER NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `first_name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(60) NOT NULL,
  `field` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`trainer_id`)
);

CREATE TABLE IF NOT EXISTS `tickets_trainee` (
  `ticket_id` INT NOT NULL,
  `trainee_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `trainee_id`)
);

CREATE TABLE IF NOT EXISTS `trainee` (
  `trainee_id` INTEGER NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `first_name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(60) NOT NULL,
  `cohort` VARCHAR(40) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`trainee_id`)
);

CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` INTEGER NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `issue` VARCHAR(244) NOT NULL,
  `topic` VARCHAR(30) NOT NULL,
  `submit_date` TIMESTAMP NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `urgency` INT NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `trainee_id` INT NOT NULL,
  `trainer_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`)
);

INSERT INTO `trainer` VALUES (1,'BenDover1','Ben', 'Dover', 'DevOps', 'mypass321', 'b.dover@gmail.com');

