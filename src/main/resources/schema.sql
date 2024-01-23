DROP TABLE IF EXISTS climbing_gym;

create table climbing_gym(
    id int NOT NULL AUTO_INCREMENT,
    climbing_gym_name varchar,
    address varchar,
    owner varchar,
    contact varchar,
    email varchar,
    poster_link varchar,
    CONSTRAINT CLIMBING_GYM_PK PRIMARY KEY(id)
);

DROP TABLE IF EXISTS daily_pass;

create table daily_pass
(
    id   int NOT NULL AUTO_INCREMENT,
    climbing_gym_id int,
    signature_status           varchar,
    user_name           varchar,
    contact             varchar,
    daily_use_contract           varchar,
    privacy_contract             varchar,
    submit_date_time datetime,
    request_date_time datetime,
    CONSTRAINT DAILY_PASS_PK PRIMARY KEY (id)
);