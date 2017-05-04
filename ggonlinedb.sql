-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ggonlinedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ggonlinedb` ;

-- -----------------------------------------------------
-- Schema ggonlinedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ggonlinedb` DEFAULT CHARACTER SET utf8 ;
USE `ggonlinedb` ;

-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `genera` VARCHAR(50) NULL DEFAULT NULL,
  `rating` VARCHAR(1) NULL DEFAULT NULL,
  `description` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team` ;

CREATE TABLE IF NOT EXISTS `team` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `active` TINYINT(1) NULL DEFAULT NULL,
  `game_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_team_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_team_game1_idx` ON `team` (`game_id` ASC);


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NULL DEFAULT NULL,
  `status` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `captain`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `captain` ;

CREATE TABLE IF NOT EXISTS `captain` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` TINYINT(1) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `team_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_captain_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_captain_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_captain_user1_idx` ON `captain` (`user_id` ASC);

CREATE INDEX `fk_captain_team1_idx` ON `captain` (`team_id` ASC);


-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

CREATE TABLE IF NOT EXISTS `message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(500) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `created_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `message_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_message_message1`
    FOREIGN KEY (`message_id`)
    REFERENCES `message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_message_user1_idx` ON `message` (`user_id` ASC);

CREATE INDEX `fk_message_message1_idx` ON `message` (`message_id` ASC);


-- -----------------------------------------------------
-- Table `user_team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_team` ;

CREATE TABLE IF NOT EXISTS `user_team` (
  `user_id` INT(11) NOT NULL,
  `team_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_has_team_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_team_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_user_has_team_team1_idx` ON `user_team` (`team_id` ASC);

CREATE INDEX `fk_user_has_team_user_idx` ON `user_team` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `message_recipient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message_recipient` ;

CREATE TABLE IF NOT EXISTS `message_recipient` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `message_id` INT(11) NOT NULL,
  `user_team_id` INT(11) NOT NULL,
  `is_read` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_recipient_message1`
    FOREIGN KEY (`message_id`)
    REFERENCES `message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipient_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipient_user_team1`
    FOREIGN KEY (`user_team_id`)
    REFERENCES `user_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_recipient_user1_idx` ON `message_recipient` (`user_id` ASC);

CREATE INDEX `fk_recipient_message1_idx` ON `message_recipient` (`message_id` ASC);

CREATE INDEX `fk_recipient_user_team1_idx` ON `message_recipient` (`user_team_id` ASC);


-- -----------------------------------------------------
-- Table `rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rating` ;

CREATE TABLE IF NOT EXISTS `rating` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `rating` INT(11) NULL DEFAULT NULL,
  `comment` VARCHAR(100) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_rating_user1_idx` ON `rating` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `user_game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_game` ;

CREATE TABLE IF NOT EXISTS `user_game` (
  `user_id` INT(11) NOT NULL,
  `game_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_has_game_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_game_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_user_has_game_game1_idx` ON `user_game` (`game_id` ASC);

CREATE INDEX `fk_user_has_game_user1_idx` ON `user_game` (`user_id` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO user1;
 DROP USER user1;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'user1';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `game` (`id`, `name`, `genera`, `rating`, `description`) VALUES (1, 'Rocket League', 'Sport', 'E', 'Soccer with RC Cars!');
INSERT INTO `game` (`id`, `name`, `genera`, `rating`, `description`) VALUES (2, 'League Of Legends', 'MOBA', 'E', 'MOBA battles and fun');

COMMIT;


-- -----------------------------------------------------
-- Data for table `team`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `team` (`id`, `name`, `created_time`, `active`, `game_id`) VALUES (1, 'Tiesto', NULL, 1, 1);
INSERT INTO `team` (`id`, `name`, `created_time`, `active`, `game_id`) VALUES (2, 'MonkyBarrel', NULL, 0, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `user` (`username`, `email`, `password`, `create_time`, `id`, `fname`, `lname`, `active`, `status`) VALUES ('stefun26', 'stefanfuller31@gmail.com', 'bigf@rts', NULL, 1, 'Stefan', 'Fuller', NULL, NULL);
INSERT INTO `user` (`username`, `email`, `password`, `create_time`, `id`, `fname`, `lname`, `active`, `status`) VALUES ('kumar007', 'kumar72@gmail.com', 'chandino27', NULL, 2, 'Chandan', 'Thakur', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `message`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `message` (`id`, `message`, `user_id`, `created_date`, `message_id`) VALUES (1, 'GG Easy', 1, NULL, 1);
INSERT INTO `message` (`id`, `message`, `user_id`, `created_date`, `message_id`) VALUES (2, 'Get good scrub', 2, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_team`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `user_team` (`user_id`, `team_id`, `id`) VALUES (1, 1, DEFAULT);
INSERT INTO `user_team` (`user_id`, `team_id`, `id`) VALUES (2, 1, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `rating` (`id`, `rating`, `comment`, `user_id`) VALUES (1, 10, 'This guys is awesome!', 1);
INSERT INTO `rating` (`id`, `rating`, `comment`, `user_id`) VALUES (2, 5, 'Great player but toxic', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_game`
-- -----------------------------------------------------
START TRANSACTION;
USE `ggonlinedb`;
INSERT INTO `user_game` (`user_id`, `game_id`, `id`) VALUES (1, 1, DEFAULT);
INSERT INTO `user_game` (`user_id`, `game_id`, `id`) VALUES (2, 2, DEFAULT);
INSERT INTO `user_game` (`user_id`, `game_id`, `id`) VALUES (1, 2, DEFAULT);
INSERT INTO `user_game` (`user_id`, `game_id`, `id`) VALUES (2, 1, DEFAULT);

COMMIT;

