create table if not exists cars
(
    id int NOT NULL AUTO_INCREMENT,
    model varchar(100) NOT NULL,
    picture varchar(50) NOT NULL,
    average_price int NOT NULL,
    year int NOT NULL,
    brand_id int NOT NULL,
    FOREIGN KEY(brand_id) references brands(id),
    PRIMARY KEY(id)
);

insert into cars(model,picture,average_price,year,brand_id) values
("Voiture V 1","undefined.png",1000,2015,1),
("Voiture W 2","undefined.png",1000,2012,1),
("Voiture A 3","undefined.png",1000,2015,1),
("Voiture B 4","undefined.png",1000,2015,1),
("Voiture C 5","undefined.png",1000,2016,1),
("Voiture D 6","undefined.png",1000,2022,1),
("Voiture E 7","undefined.png",1000,2015,4),
("Voiture F 8","undefined.png",1000,2015,1),
("Voiture G 9","undefined.png",1000,2015,3),
("Voiture H 10","undefined.png",1000,2015,1),
("Voiture I 11","undefined.png",1000,2015,2);