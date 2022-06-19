/*create a table that represents the resort_register*/
CREATE TABLE IF NOT EXISTS booking_system.resort_register
(
    id                     BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resort_register_status VARCHAR(255),
    resort_id              BIGINT UNIQUE,
    created_at             TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/*create a table that represents the resort_register_comment*/
CREATE TABLE IF NOT EXISTS booking_system.resort_register_comment
(
    id                 BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    comment            VARCHAR(255)       NOT NULL,
    resort_register_id BIGINT UNIQUE,
    created_at         TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE booking_system.resort_register
    ADD CONSTRAINT resort_register_resort_fk
        FOREIGN KEY (resort_id) REFERENCES booking_system.resort (id);

ALTER TABLE booking_system.resort_register_comment
    ADD CONSTRAINT resort_register_comment_resort_register_fk
        FOREIGN KEY (resort_register_id) REFERENCES booking_system.resort_register (id);



ALTER TABLE booking_system.users
    ADD country VARCHAR(255) NOT NULL;

