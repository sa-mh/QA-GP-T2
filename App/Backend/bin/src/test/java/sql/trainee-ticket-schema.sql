DROP TABLE IF EXISTS `trainee_ticket` CASCADE;

CREATE TABLE `trainee_ticket` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`trainee_id` BIGINT NOT NULL,
	`ticket_id` BIGINT NOT NULL,
	FOREIGN KEY (`trainee_id`) REFERENCES `trainee`(`id`),
	FOREIGN KEY (`ticket_id`) REFERENCES `ticket`(`id`)
);