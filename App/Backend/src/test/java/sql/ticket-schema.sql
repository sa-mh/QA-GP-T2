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