CREATE DATABASE IF NOT EXISTS `test`;

USE `test`;

DROP TABLE IF EXISTS `ticket` CASCADE;

CREATE TABLE `ticket` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(30) NOT NULL,
    `issue` VARCHAR(200) NOT NULL,
    `topic` VARCHAR(20) NOT NULL,
    `submit_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `urgency` INT NOT NULL,
    `status` VARCHAR(20) NOT NULL,
    `author` VARCHAR(20) NOT NULL,
    `solution` VARCHAR(200)
);

INSERT INTO `ticket`
(
  `title`,
  `issue`,
  `topic`,
  `submit_date`,
  `urgency`,
  `status`,
  `author`,
  `solution`
)
VALUES
(
  'A title',
  'An issue',
  'A topic',
  '1970-01-01T00:00:00.010+00:00',
  4,
  'Open',
  'A author',
  NULL
);