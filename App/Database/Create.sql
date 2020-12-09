CREATE DATABASE IF NOT EXISTS `test`;

USE `test`;

CREATE TABLE IF NOT EXISTS `trainer` (
  `trainer_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `first_name` VARCHAR(60) NOT NULL,
  `last_name` VARCHAR(60) NOT NULL,
  `field` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `trainer_email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`trainer_id`)
);

CREATE TABLE IF NOT EXISTS `tickets_trainee` (
  `ticket_id` INT NOT NULL,
  `trainee_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `trainee_id`),
  FOREIGN KEY (`trainee_id`) REFERENCES trainee(trainee_id),
  FOREIGN KEY (`ticket_id`) REFERENCES ticket(ticket_id)
);

CREATE TABLE IF NOT EXISTS `trainee` (
  `trainee_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `first_name` VARCHAR(60) NOT NULL,
  `second_name` VARCHAR(60) NOT NULL,
  `cohort` VARCHAR(40) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `trainee_email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`trainee_id`)
);

CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `issue` VARCHAR(244) NOT NULL,
  `topic` VARCHAR(30) NOT NULL,
  `submit_date` timestamp NOT NULl default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `urgency` INT NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `trainee_id` int NOT NULL,
  `trainer_id` int NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`trainee_id`) REFERENCES trainee(trainee_id),
  FOREIGN KEY (`trainer_id`) REFERENCES trainer(trainer_id)
);

INSERT INTO `trainer` (
  `trainer_id`,
  `username`,
  `first_name`,
  `last_name`,
  `field`,
  `password`,
  `trainer_email`
)
VALUES (
  NULL,
  'BenDover1',
  'Ben',
  'Dover', 
  'DevOps',
  'mypass321',
  'b.dover@gmail.com'
);

INSERT INTO `trainee` (
  `trainee_id`,
  `username`,
  `first_name`,
  `second_name`,
  `cohort`,
  `password`,
  `trainee_email`
)
VALUES (
  NULL,
  'JHarry4',
  'Jordan',
  'Harrison', 
  'Everything',
  'SudoSecurePass',
  'j.harrry@gmail.com'
);

INSERT INTO `ticket` (
  `ticket_id`,
  `title`,
  `issue`,
  `topic`,
  `submit_date`,
  `urgency`,
  `status`,
  `trainee_id`,
  `trainer_id`
)
VALUES (
  NULL,
  'Help Me Pls',
  'I cannot get this ticket to display',
  'MySQL', 
  '01-JAN-2003 2:00:00',
  '4',
  'new',
  '1',
  '2'
);
