create table if not exists users
(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(80) NOT NULL,
    password varchar(150) NOT NULL,
    firstname varchar(100) NOT NULL,
    lastname varchar(100) NOT NULL,
    PRIMARY KEY(id)
)