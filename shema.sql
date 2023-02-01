CREATE TABLE `jabflix_db`.`user` (
    `user_id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `email` VARCHAR(500) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `phone_number` VARCHAR(100) NULL,
    `name` VARCHAR(100) NULL,
    `birth` VARCHAR(50) NULL,
    `membership` VARCHAR(100) NOT NULL DEFAULT 'FREE' COMMENT 'FREE /  BASIC / STANDARD / PREMIUM',
    `status` VARCHAR(100) NOT NULL DEFAULT 'ACTIVATE' COMMENT 'ACTIVATE / DELETED',
    `card_number` VARCHAR(100) NULL,
    `card_expiration_date` VARCHAR(50) NULL,
    `paid_at` DATETIME NULL,
    `created_at` DATETIME NOT NULL,
    `withdraw_at` DATETIME NULL
);

CREATE TABLE `jabflix_db`.`profile` (
    `profile_id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `name` VARCHAR(100) NOT NULL COMMENT 'user+숫자',
    `icon` LONGTEXT NOT NULL COMMENT '기본아이콘'
);

CREATE TABLE `jabflix_db`.`content` (
    `content_id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `genre` VARCHAR(100) NOT NULL,
    `title` VARCHAR(500) NOT NULL,
    `overview` TEXT NOT NULL,
    `season_number` INT NULL,
    `episode_number` INT NULL,
    `run_time` INT NOT NULL,
    `released_at` DATE NOT NULL,
    `poster_path` LONGTEXT NOT NULL,
    `backdrop_path` LONGTEXT NOT NULL
);

CREATE TABLE `jabflix_db`.`like` (
    `like_id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `profile_id` BIGINT NOT NULL,
    `content_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL
);

CREATE TABLE `jabflix_db`.`wish` (
    `wish_id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `profile_id` BIGINT NOT NULL,
    `content_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL
);

ALTER TABLE `jabflix_db`.`profile` ADD CONSTRAINT `FK_user_TO_profile_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `jabflix_db`.`like` ADD CONSTRAINT `FK_profile_TO_like_1` FOREIGN KEY (
	`profile_id`
)
REFERENCES `profile` (
	`user_id`
);

ALTER TABLE `jabflix_db`.`like` ADD CONSTRAINT `FK_content_TO_like_1` FOREIGN KEY (
	`content_id`
)
REFERENCES `content` (
	`content_id`
);

ALTER TABLE `jabflix_db`.`wish` ADD CONSTRAINT `FK_profile_TO_wish_1` FOREIGN KEY (
	`profile_id`
)
REFERENCES `profile` (
	`profile_id`
);

ALTER TABLE `jabflix_db`.`wish` ADD CONSTRAINT `FK_content_TO_wish_1` FOREIGN KEY (
	`content_id`
)
REFERENCES `content` (
	`content_id`
);

ALTER TABLE `jabflix_db`.`user` ADD CONSTRAINT `UK_user_email` unique (
	`email`
);

ALTER TABLE `jabflix_db`.`user` ADD `role` VARCHAR(50);