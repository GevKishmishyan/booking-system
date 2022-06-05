/*created a table that represents the resort*/
CREATE TABLE IF NOT EXISTS booking_system.resort
(
    id                BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name              VARCHAR(255)       NOT NULL,
    resort_type       VARCHAR(255),
    star              INTEGER,
    email             VARCHAR(255)       NOT NULL,
    telephone         VARCHAR(255),
    description       TEXT(255),
    address_id        BIGINT UNIQUE,
    rate_id           BIGINT UNIQUE,
    resort_details_id BIGINT UNIQUE,
    resort_number_id  BIGINT UNIQUE,
    tin_id            BIGINT UNIQUE
);

/*created a table that represents the room*/
CREATE TABLE IF NOT EXISTS booking_system.room
(
    id               BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_number      INTEGER            NOT NULL,
    resort_number_id BIGINT,
    resort_id        BIGINT
);

/*created a table that represents the resort_number */
CREATE TABLE IF NOT EXISTS booking_system.resort_number
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_type       VARCHAR(255),
    per_night_price DECIMAL            NOT NULL,
    room_details_id BIGINT UNIQUE
);

/*create table that store pictures url of room pictur*/
CREATE TABLE IF NOT EXISTS booking_system.room_picture
(
    id               BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    picture_url      VARCHAR(255),
    resort_number_id BIGINT
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

/*created a table that represents the address*/
CREATE TABLE IF NOT EXISTS booking_system.address
(
    id      BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    country VARCHAR(255)       NOT NULL,
    region  VARCHAR(255)       NOT NULL,
    section VARCHAR(255)       NOT NULL,
    address VARCHAR(255)       NOT NULL
);

/*created a table that represents the tin*/
CREATE TABLE IF NOT EXISTS booking_system.tin
(
    id            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    serial_number VARCHAR(255),
    document      VARCHAR(255)       NOT NULL
);

/*created a table that represents the rate*/
CREATE TABLE IF NOT EXISTS booking_system.rate
(
    id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rating      DOUBLE,
    total_rate  DOUBLE,
    rates_count INTEGER
);

/*created a table that represents the resort details*/
CREATE TABLE IF NOT EXISTS booking_system.resort_details
(
    id                             BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    airport_shuttle                BOOLEAN,
    free_wi_fi                     BOOLEAN,
    bar                            BOOLEAN,
    breakfast                      BOOLEAN,
    tea_coffee_maker               BOOLEAN,
    non_smoking_rooms              BOOLEAN,
    spa_and_wellness               BOOLEAN,
    fitness_center                 BOOLEAN,
    facilities_for_disabled_guests BOOLEAN,
    restaurant                     BOOLEAN,
    private_parking                BOOLEAN
);

/*created a table that represents the review*/
CREATE TABLE IF NOT EXISTS booking_system.review
(
    id        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rate      DOUBLE,
    comment   VARCHAR(255),
    resort_id BIGINT,
    users_id  BIGINT
);

/*created a table that represents the booking*/
CREATE TABLE IF NOT EXISTS booking_system.booking
(
    id           BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    booked_from  DATETIME,
    booked_to    DATETIME,
    total_amount DECIMAL            NOT NULL,
    room_id      BIGINT,
    users_id     BIGINT
);

/*created a table that represents the user*/
CREATE TABLE IF NOT EXISTS booking_system.users
(
    id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name      VARCHAR(255)       NOT NULL,
    last_name       VARCHAR(255)       NOT NULL,
    birthday        DATE,
    gender          VARCHAR(255),
    email           VARCHAR(255)       NOT NULL,
    role            VARCHAR(255),
    enabled         BOOLEAN,
    blocked         BOOLEAN,
    profile_picture VARCHAR(255),
    password        VARCHAR(255),
    created_at      TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    access_code_id  BIGINT UNIQUE
);

CREATE TABLE IF NOT EXISTS booking_system.access_code
(
    id         BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    code       VARCHAR(255)       NOT NULL,
    created_at TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE booking_system.resort
    ADD CONSTRAINT resort_address_fk
        FOREIGN KEY (address_id) REFERENCES booking_system.address (id),
    ADD CONSTRAINT resort_rate_fk
        FOREIGN KEY (rate_id) REFERENCES booking_system.rate (id),
    ADD CONSTRAINT resort_resort_details_fk
        FOREIGN KEY (resort_details_id) REFERENCES booking_system.resort_details (id),
    ADD CONSTRAINT resort_tin_fk
        FOREIGN KEY (tin_id) REFERENCES booking_system.tin (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.room
    ADD CONSTRAINT room_resort_fk
        FOREIGN KEY (resort_id) REFERENCES booking_system.resort (id),
    ADD CONSTRAINT room_resort_number_fk
        FOREIGN KEY (resort_number_id) REFERENCES booking_system.resort_number (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.resort_number
    ADD CONSTRAINT resort_number_room_details_fk
        FOREIGN KEY (room_details_id) REFERENCES booking_system.room_details (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.room_picture
    ADD CONSTRAINT room_pictures_resort_number_fk
        FOREIGN KEY (resort_number_id) REFERENCES booking_system.resort_number (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.review
    ADD CONSTRAINT review_resort_fk
        FOREIGN KEY (resort_id) REFERENCES booking_system.resort (id),
    ADD CONSTRAINT review_users_fk
        FOREIGN KEY (users_id) REFERENCES booking_system.users (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.booking
    ADD CONSTRAINT booking_room_fk
        FOREIGN KEY (room_id) REFERENCES booking_system.room (id),
    ADD CONSTRAINT booking_users_fk
        FOREIGN KEY (users_id) REFERENCES booking_system.users (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;

ALTER TABLE booking_system.users
    ADD CONSTRAINT users_access_code_fk
        FOREIGN KEY (access_code_id) REFERENCES booking_system.access_code (id)
            ON DELETE CASCADE ON UPDATE RESTRICT;