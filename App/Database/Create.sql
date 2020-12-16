CREATE DATABASE IF NOT EXISTS `test`;

USE `test`;

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


DROP TABLE IF EXISTS `trainee` CASCADE;

CREATE TABLE `trainee` (
 	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
 	`username` VARCHAR(60) NOT NULL,
 	`first_name` VARCHAR(60) NOT NULL,
 	`last_name` VARCHAR(60) NOT NULL,
 	`cohort` VARCHAR(40) NOT NULL,
 	`password` VARCHAR(45) NOT NULL,
 	`trainee_email` VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS `ticket` CASCADE;

CREATE TABLE `ticket` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `issue` VARCHAR(20) NOT NULL,
 	`topic` VARCHAR(20) NOT NULL,
 	`submit_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	`urgency` INT NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `trainer_id` BIGINT NOT NULL,
  FOREIGN KEY (`trainer_id`) REFERENCES `trainer`(`id`)
);

DROP TABLE IF EXISTS `trainee_ticket` CASCADE;

CREATE TABLE `trainee_ticket` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`trainee_id` BIGINT NOT NULL,
	`ticket_id` BIGINT NOT NULL,
	FOREIGN KEY (`trainee_id`) REFERENCES `trainee`(`id`),
	FOREIGN KEY (`ticket_id`) REFERENCES `ticket`(`id`)
);

INSERT INTO `trainer`
(
`username`,
`first_name`,
`last_name`,
`password`,
`field`,
`trainer_email`)
VALUES
(
'TheBobinator',
'Bob',
'Bobothy',
'mypassword123',
'DevOps',
'bob@qa.com'
);

INSERT INTO `trainee`
(
`username`,
`first_name`,
`last_name`,
`cohort`,
`password`,
`trainee_email`)
VALUES
(
'Student1',
'Student',
'Study',
'CNE',
'secure123',
'student@qa.com');


INSERT INTO `ticket`
(`title`,
`issue`,
`topic`,
`submit_date`,
`urgency`,
`status`,
`trainer_id`
)
VALUES
('My First',
'Help me',
'SQL',
NULL,
3,
'Pending',
1);


INSERT INTO `trainee_ticket`
(`id`,
`trainee_id`,
`ticket_id`)
VALUES
(1,
1,
1);
