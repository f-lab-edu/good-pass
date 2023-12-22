use GOOD_PASS;

drop table CLIMBING_GYM;

create table `CLIMBING_GYM`(
                               `id` int(10) NOT NULL AUTO_INCREMENT,
                               `climbing_gym_name` varchar(30),
                               `address` varchar(50),
                               `owner` varchar(10),
                               `contact` varchar(13),
                               `email` varchar(30),
                               CONSTRAINT `CLIMBING_GYM_PK` PRIMARY KEY(`id`)
);

drop table DAILY_PASS;

create table `DAILY_PASS`
(
    `id`   int(10) NOT NULL AUTO_INCREMENT,
    `climbing_gym_id` int(10),
    `signature_status`           varchar(10),
    `user_name`           varchar(50),
    `contact`             varchar(10),
    `daily_use_contract`           varchar(13),
    `privacy_contract`             varchar(30),
    `signature_id` varchar(20),
    `submit_time` datetime,
    CONSTRAINT `DAILY_PASS_PK` PRIMARY KEY (`id`)
);

select * from CLIMBING_GYM;

select * from DAILY_PASS;