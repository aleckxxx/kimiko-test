create table if not exists comments
(
    id int NOT NULL AUTO_INCREMENT,
    content text NOT NULL,
    created_at datetime NOT NULL,
    car_id int NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY(car_id) references CARS(id),
    FOREIGN KEY(user_id) references USERS(id),
    PRIMARY KEY(id)
)