

create table if not exists `CLIMBING_GYM`(
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `climbing_gym_name` varchar(30),
                               `address` varchar(50),
                               `owner` varchar(10),
                               `contact` varchar(13),
                               `email` varchar(30),
                               `message` varchar(100), -- 여기다 하는 게 맞을까요...?
                               -- 클라이밍장 정보를 커스터마이징해서 보여주는 서비스가 많아지면 table을 추가하는 것도 괜찮아보이거든요.
                                PRIMARY KEY(`id`)
);


create table if not exists `DAILY_PASS`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `climbing_gym_id` bigint,
    `signature_status`           varchar(10),
    `user_name`           varchar(50),
    `contact`             varchar(10),
    `daily_use_contract`           varchar(13),
    `privacy_contract`             varchar(30),
    `signature_id` varchar(20),
    `submit_time` datetime,
    PRIMARY KEY (`id`)
);
