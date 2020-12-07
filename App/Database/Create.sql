CREATE DATABASE IF NOT EXISTS `test`;

USE `test`;

CREATE TABLE IF NOT EXISTS `Trainer` (
  `trainerId` INTEGER NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `firstName` VARCHAR(60) NOT NULL,
  `lastName` VARCHAR(60) NOT NULL,
  `field` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`trainerId`)
);

CREATE TABLE IF NOT EXISTS `Tickets_Trainee` (
  `ticketId` INT NOT NULL,
  `traineeI` INT NOT NULL,
  PRIMARY KEY (`ticketId`, `traineeId`)
);

CREATE TABLE IF NOT EXISTS `Trainee` (
  `traineeId` INTEGER NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `firstName` VARCHAR(60) NOT NULL,
  `lastName` VARCHAR(60) NOT NULL,
  `cohort` VARCHAR(40) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`traineeId`)
);

CREATE TABLE IF NOT EXISTS `Ticket` (
  `ticketId` INTEGER NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `issue` VARCHAR(244) NOT NULL,
  `topic` VARCHAR(30) NOT NULL,
  `submitDate` TIMESTAMP NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `urgency` INT NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `traineeId` INT NOT NULL,
  `trainerId` INT NOT NULL,
  PRIMARY KEY (`ticketId`)
);

INSERT INTO `Trainer` VALUES (1,'BenDover1','Ben', 'Dover', 'DevOps', 'mypass321');
