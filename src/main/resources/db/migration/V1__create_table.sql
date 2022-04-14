/*create table that store pictures url of room*/
CREATE TABLE if NOT EXISTS `booking_system`.`room_pictures`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `pic_url`            VARCHAR(255)
);

/*created a table that represents the room*/
CREATE TABLE if NOT EXISTS `booking_system`.`resort_number`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `room_type`          VARCHAR(255),
    `room_pic`           INT(16),
    `room_details_id`    INT(16) UNIQUE,
    `available_count`    INTEGER,
    `perNightPrice`      DECIMAL
);

/*created a table that represents the room service*/
CREATE TABLE if NOT EXISTS `booking_system`.`room_details`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `airConditioner`     BOOLEAN,
    `tv`                 BOOLEAN,
    `sofa`               BOOLEAN,
    `tea_table`          BOOLEAN,
    `shower`             BOOLEAN,
    `bathtub`            BOOLEAN,
    `bath_accessories`   BOOLEAN,
    `hairdryer`          BOOLEAN,
    `minibar`            BOOLEAN,
    `fridge`             BOOLEAN,
    `dishes`             BOOLEAN,
    `electric_kettle`    BOOLEAN
);

/*created a table that represents the booking*/
CREATE TABLE if NOT EXISTS `booking_system`.`booking`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `booked_from`        DATETIME,
    `booked_to`          DATETIME,
    `all_pricе`          DECIMAL
);

/*created a table that represents the room*/
CREATE TABLE if NOT EXISTS `booking_system`.`room`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `room_number`        INT(16),
    `resort_number_id`   INT(16) UNIQUE,
    `booking_id`         INT(16)
);

/*created a table that represents the address*/
CREATE TABLE if NOT EXISTS `booking_system`.`address`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `country`            VARCHAR(255) NOT NULL,
    `region`             VARCHAR(255) NOT NULL,
    `city_village`       VARCHAR(255) NOT NULL,
    `address`            VARCHAR(255) NOT NULL
);

/*created a table that represents the tin*/
CREATE TABLE if NOT EXISTS `booking_system`.`tin`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `serial_number`      VARCHAR(255),
    `document`           VARCHAR(255)
);

/*created a table that represents the rate*/
CREATE TABLE if NOT EXISTS `booking_system`.`rate` (
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `rating`             DOUBLE,
    `total_rate`         DOUBLE,
    `rates_count`        INTEGER
);

/*created a table that represents the review*/
CREATE TABLE if NOT EXISTS `booking_system`.`review` (
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `booking_id`         INT(16) NOT NULL,
    `rate`               DOUBLE,
    `comment`            VARCHAR(255)
);

/*created a table that represents the hotel*/
CREATE TABLE if NOT EXISTS `booking_system`.`resort`(
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`               VARCHAR(255),
    `address_id`         INT(16) UNIQUE,
    `room_type`          VARCHAR(255),
    `tin_id`             INT(16) UNIQUE,
    `resort_details_id`  INT(16) UNIQUE,
    `star`               INT(16),
    `rate_id`            INT(16) UNIQUE,
    `email`              VARCHAR(255),
    `telephone`          VARCHAR(255),
    `description`        TEXT(255),
    `rooms_id`           INT(16),
    `reviews_id`         INT(16)
);

/*created a table that represents the user*/
CREATE TABLE if NOT EXISTS `booking_system`.`user` (
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `first_name`         VARCHAR(255),
    `last_name`          VARCHAR(255),
    `birthday`           DATE,
    `gender`             VARCHAR(255),
    `email`              VARCHAR(255),
    `role`               VARCHAR(255),
    `is_active`          BOOLEAN,
    `profile_picture`    VARCHAR(255),
    `password`           VARCHAR(255),
    `reviews_us_id`      INT(16),
    `booking_us_id`      INT(16),
    `created_at`         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/*created a table that represents the resort details*/
CREATE TABLE if NOT EXISTS `booking_system`.`resort_details` (
    `id`                 INT(16) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `airportShuttle`     BOOLEAN,
    `freeWiFi`           BOOLEAN,
    `bar`                BOOLEAN,
    `breakfast`          BOOLEAN,
    `teaCoffeeMaker`     BOOLEAN,
    `nonSmokingRooms`    BOOLEAN,
    `spaAndWellnes`      BOOLEAN,
    `fitnessCenter`      BOOLEAN,
    `facilitiesForDisableGuests`  BOOLEAN,
    `restaurant`         BOOLEAN,
    `privateParking`     BOOLEAN
);

/*The pic_URL of the room connects with the room*/
ALTER TABLE `booking_system`.`resort_number`
    ADD CONSTRAINT `room_pic`
        FOREIGN KEY (`room_pic`) REFERENCES `booking_system`.`room_pictures` (`id`),
    ADD CONSTRAINT `room_details_id`
        FOREIGN KEY (`room_details_id`) REFERENCES `booking_system`.`room_details` (`id`)
            ON DELETE CASCADE ON UPDATE RESTRICT ;

/*The  room connects (contains) with the Hotel_Room*/
ALTER TABLE `booking_system`.`room`
    ADD CONSTRAINT `resort_number_id`
        FOREIGN KEY (`resort_number_id`) REFERENCES `booking_system`.`resort_number` (`id`),
    ADD CONSTRAINT `booking_id`
        FOREIGN KEY (`booking_id`) REFERENCES `booking_system`.`booking` (`id`)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The  hotel connects (contains) with the address*/
ALTER TABLE `booking_system`.`resort`
    ADD CONSTRAINT `address_id`
        FOREIGN KEY (`address_id`) REFERENCES `booking_system`.`address` (`id`),
    ADD CONSTRAINT `tin_id`
        FOREIGN KEY (`tin_id`) REFERENCES `booking_system`.`tin` (`id`),
    ADD CONSTRAINT `resort_details_id`
        FOREIGN KEY (`resort_details_id`) REFERENCES `booking_system`.`resort_details` (`id`),
    ADD CONSTRAINT `rooms_id`
        FOREIGN KEY (`rooms_id`) REFERENCES `booking_system`.`room` (`id`),
    ADD CONSTRAINT `reviews_id`
        FOREIGN KEY (`reviews_id`) REFERENCES `booking_system`.`review` (`id`),
    ADD CONSTRAINT `rate_id`
        FOREIGN KEY (`rate_id`) REFERENCES `booking_system`.`rate` (`id`)
            ON DELETE SET NULL ON UPDATE RESTRICT ;

/*The  user connects (contains) with the booking*/
ALTER TABLE `booking_system`.`user`
    ADD CONSTRAINT `booking_us_id`
        FOREIGN KEY (`booking_us_id`) REFERENCES `booking_system`.`booking` (`id`),
    ADD CONSTRAINT `reviews_us_id`
        FOREIGN KEY (`reviews_us_id`) REFERENCES `booking_system`.`review` (`id`)
            ON DELETE CASCADE ON UPDATE RESTRICT ;

