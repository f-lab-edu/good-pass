DROP TABLE IF EXISTS climbing_gym;

create table climbing_gym(
    id bigint NOT NULL AUTO_INCREMENT,
    climbing_gym_name varchar(40),
    address varchar(100),
    owner varchar(15),
    contact varchar(15),
    email varchar(25),
    poster_link varchar(100),
    CONSTRAINT CLIMBING_GYM_PK PRIMARY KEY(id)
);

DROP TABLE IF EXISTS daily_pass;

create table daily_pass
(
    id   bigint NOT NULL AUTO_INCREMENT,
    climbing_gym_id bigint,
    signature_status varchar(10),
    user_name varchar(15),
    contact varchar(15),
    daily_use_contract varchar(6),
    privacy_contract varchar(6),
    submit_datetime datetime,
    request_datetime datetime,
    CONSTRAINT DAILY_PASS_PK PRIMARY KEY (id)
);