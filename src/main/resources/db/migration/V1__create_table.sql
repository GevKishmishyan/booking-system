create table if not exists booking_system.room_pictures(
    `id` int(16) NOT NULL AUTO_INCREMENT,
    `pic_url` varchar(255),
    primary key (id)
);

create  table  if not exists booking_system.hotel_room(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `room_type` enum ('STANDART', 'DELUXE'),
    `room_pic` int(16),
    `available_count` INTEGER,
    `price` DECIMAL,
    primary key (id)
);

ALTER TABLE `booking_system`.`hotel_room`
    ADD CONSTRAINT `room_pic`
        FOREIGN KEY (`room_pic`) REFERENCES `booking_system`.`room_pictures` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;


create table  `booking_system`.booking(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `booked_from` datetime,
    `booked_to` datetime,
    `all_pric` decimal,
    primary key (id)
);

create table if not exists booking_system.room(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `room_number` INTEGER(11),
    `hotel_room_id` int(16) unique,
    `booking_id` int(16),
    primary key (id)

);

ALTER TABLE `booking_system`.`room`
    ADD CONSTRAINT `hotel_room_id`
        FOREIGN KEY (`hotel_room_id`) REFERENCES `booking_system`.`hotel_room` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `booking_system`.`room`
    ADD CONSTRAINT `booking_id`
        FOREIGN KEY (`booking_id`) REFERENCES `booking_system`.`booking` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

create table if not exists booking_system.address(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    `country`varchar (255) not null,
    `region`varchar (255) not null,
    `city_village`varchar (255) not null,
    `address`varchar (255) not null,
    primary key (id)
);

create table if not exists booking_system.tin(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(), TRUE)),
    `serial_number` varchar(255),
    `document` varchar(255),
    primary key (id)
);

create table if not exists booking_system.rate (
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `rating` DOUBLE,
    `total_rate` DOUBLE,
    `rates_count` INTEGER,
    primary key (id)

);

create table if not exists booking_system.review
(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `booking_id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `rate` DOUBLE,
    `comment` varchar(255),
    PRIMARY KEY (id)
);

create table if not exists booking_system.hotel(
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `name` varchar(255),
    `address_id` int(16) unique,
    `room_type` enum ('HOTEL', 'GUEST_HOUSE'),
    `tin_id` int(16) unique,
    `star` int(16),
    `rate_id` int(16) unique,
    `email` varchar(255),
    `phone_number` varchar(255),
    `description` varchar(255),
    `rooms_id` int(16),
    `reviews_id` int(16),
    primary key (id)
);

ALTER TABLE `booking_system`.`hotel`
    ADD CONSTRAINT `address_id`
        FOREIGN KEY (`address_id`) REFERENCES `booking_system`.`address` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `booking_system`.`hotel`
    ADD CONSTRAINT `tin_id`
        FOREIGN KEY (`tin_id`) REFERENCES `booking_system`.`tin` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `booking_system`.`hotel`
    ADD CONSTRAINT `rooms_id`
        FOREIGN KEY (`rooms_id`) REFERENCES `booking_system`.`room` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `booking_system`.`hotel`
    ADD CONSTRAINT `reviews_id`
        FOREIGN KEY (`reviews_id`) REFERENCES `booking_system`.`review` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

create table if not exists `booking_system`.`user` (
    `id` int(16) NOT NULL DEFAULT (UUID_TO_BIN(UUID(),TRUE)),
    `first_name` varchar(255),
    `last_name` varchar(255),
    `email` varchar(255),
    `role` enum ('ADMIN', 'MODERATOR', 'HOTEL_MANAGER', 'USER'),
    `is_active` boolean,
    `profile_picture` varchar(255),
    `password` varchar(255),
    `reviews_us_id` int(16),
    `booking_us_id` int(16),
    `created_at` datetime,
    primary key (id)
);

ALTER TABLE `booking_system`.`user`
    ADD CONSTRAINT `booking_us_id`
        FOREIGN KEY (`booking_us_id`) REFERENCES `booking_system`.`booking` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `booking_system`.`user`
    ADD CONSTRAINT `reviews_us_id`
        FOREIGN KEY (`reviews_us_id`) REFERENCES `booking_system`.`review` (`id`)
            ON DELETE NO ACTION ON UPDATE NO ACTION;