create table if not exists users
(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(80) NOT NULL,
    password varchar(50) NOT NULL,
    firstname varchar(100),
    lastname varchar(100),
    PRIMARY KEY(id)
)