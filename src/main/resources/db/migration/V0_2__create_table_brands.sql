create table if not exists brands
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    PRIMARY KEY(id)
)

insert into brands(id,name) values
(1,'Mercedes'),
(2,'Volswagen'),
(3,'Renault'),
(4,'Hyundai');

