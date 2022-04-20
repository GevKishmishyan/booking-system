/*create table that store pictures url of room*/
CREATE TABLE IF NOT EXISTS booking_system.room_pictures
(
    id               BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    picture_url      VARCHAR(255),
    resort_number_id BIGINT
);

/*created a table that represents the room*/
CREATE TABLE IF NOT EXISTS booking_system.resort_number
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_type       VARCHAR(255),
    room_details_id BIGINT UNIQUE,
    available_count INTEGER,
    per_night_price DECIMAL
);

/*created a table that represents the room service*/
CREATE TABLE IF NOT EXISTS booking_system.room_details
(
    id               BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    air_conditioner  BOOLEAN,
    tv               BOOLEAN,
    sofa             BOOLEAN,
    tea_table        BOOLEAN,
    shower           BOOLEAN,
    bathtub          BOOLEAN,
    bath_accessories BOOLEAN,
    hairdryer        BOOLEAN,
    minibar          BOOLEAN,
    fridge           BOOLEAN,
    dishes           BOOLEAN,
    electric_kettle  BOOLEAN
);

/*created a table that represents the booking*/
CREATE TABLE IF NOT EXISTS booking_system.booking
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    booked_from DATETIME,
    booked_to   DATETIME,
    all_price   DECIMAL,
    review_id   BIGINT
);

/*created a table that represents the room*/
CREATE TABLE IF NOT EXISTS booking_system.room
(
    id               BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_number      BIGINT,
    resort_number_id BIGINT UNIQUE,
    booking_id       BIGINT
);

/*created a table that represents the address*/
CREATE TABLE IF NOT EXISTS booking_system.address
(
    id           BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    country      VARCHAR(255)       NOT NULL,
    region       VARCHAR(255)       NOT NULL,
    city_village VARCHAR(255)       NOT NULL,
    address      VARCHAR(255)       NOT NULL
);

/*created a table that represents the tin*/
CREATE TABLE IF NOT EXISTS booking_system.tin
(
    id            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    serial_number VARCHAR(255),
    document      VARCHAR(255)
);

/*created a table that represents the rate*/
CREATE TABLE IF NOT EXISTS booking_system.rate
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rating      DOUBLE,
    total_rate  DOUBLE,
    rates_count INTEGER
);

/*created a table that represents the review*/
CREATE TABLE IF NOT EXISTS booking_system.review
(
    id      BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rate    DOUBLE,
    comment VARCHAR(255)
);

/*created a table that represents the hotel*/
CREATE TABLE IF NOT EXISTS booking_system.resort
(
    id                BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name              VARCHAR(255),
    address_id        BIGINT UNIQUE,
    resort_type       VARCHAR(255),
    tin_id            BIGINT UNIQUE,
    resort_details_id BIGINT UNIQUE,
    star              INTEGER,
    rate_id           BIGINT UNIQUE,
    email             VARCHAR(255),
    telephone         VARCHAR(255),
    description       TEXT(255),
    room_id           BIGINT,
    review_id         BIGINT
);

/*created a table that represents the user*/
CREATE TABLE IF NOT EXISTS booking_system.user
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name      VARCHAR(255),
    last_name       VARCHAR(255),
    birthday        DATE,
    gender          VARCHAR(255),
    email           VARCHAR(255),
    role            VARCHAR(255),
    is_active       BOOLEAN,
    profile_picture VARCHAR(255),
    password        VARCHAR(255),
    booking_id      BIGINT,
    reviews_id      BIGINT,
    created_at      TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/*created a table that represents the resort details*/
CREATE TABLE IF NOT EXISTS `booking_system`.`resort_details`
(
    id                            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    airport_shuttle               BOOLEAN,
    free_Wi_Fi                    BOOLEAN,
    bar                           BOOLEAN,
    breakfast                     BOOLEAN,
    tea_coffee_maker              BOOLEAN,
    non_smoking_rooms             BOOLEAN,
    spa_and_wellness              BOOLEAN,
    fitness_center                BOOLEAN,
    facilities_for_disable_guests BOOLEAN,
    restaurant                    BOOLEAN,
    private_parking               BOOLEAN
);

/*The pic_URL of the room connects with the room*/
ALTER TABLE booking_system.room_pictures
    ADD CONSTRAINT room_pictures_resort_number_fk
        FOREIGN KEY (resort_number_id) REFERENCES booking_system.resort_number (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The pic_URL of the room connects with the room*/
ALTER TABLE booking_system.resort_number
    ADD CONSTRAINT resort_number_room_details_fk
        FOREIGN KEY (room_details_id) REFERENCES booking_system.room_details (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The  room connects (contains) with the Hotel_Room*/
ALTER TABLE booking_system.room
    ADD CONSTRAINT room_resort_number_fk1
        FOREIGN KEY (resort_number_id) REFERENCES booking_system.resort_number (id),
    ADD CONSTRAINT room_booking_fk2
        FOREIGN KEY (booking_id) REFERENCES booking_system.booking (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The  hotel connects (contains) with the address*/
ALTER TABLE booking_system.resort
    ADD CONSTRAINT resort_address_fk1
        FOREIGN KEY (address_id) REFERENCES booking_system.address (id),
    ADD CONSTRAINT resort_tin_fk2
        FOREIGN KEY (tin_id) REFERENCES booking_system.tin (id),
    ADD CONSTRAINT resort_resort_details_fk3
        FOREIGN KEY (resort_details_id) REFERENCES booking_system.resort_details (id),
    ADD CONSTRAINT resort_room_fk4
        FOREIGN KEY (room_id) REFERENCES booking_system.room (id),
    ADD CONSTRAINT resort_review_fk5
        FOREIGN KEY (review_id) REFERENCES booking_system.review (id),
    ADD CONSTRAINT resort_rate_fk6
        FOREIGN KEY (rate_id) REFERENCES booking_system.rate (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The  user connects (contains) with the booking*/
ALTER TABLE booking_system.user
    ADD CONSTRAINT user_booking_fk1
        FOREIGN KEY (booking_id) REFERENCES booking_system.booking (id),
    ADD CONSTRAINT user_reviews_fk2
        FOREIGN KEY (reviews_id) REFERENCES booking_system.review (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

/*The booking connects (contains) with the review*/
ALTER TABLE booking_system.booking
    ADD CONSTRAINT booking_review_fk1
        FOREIGN KEY (review_id) REFERENCES booking_system.review (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;
