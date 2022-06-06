/*create a table that represents the resort_register_request*/
CREATE TABLE IF NOT EXISTS booking_system.resort_register_request
(
    id                        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    resort_register_status    VARCHAR(255),
    resort_id                 BIGINT UNIQUE
);

ALTER TABLE booking_system.resort_register_request
    ADD CONSTRAINT resort_register_request_resort_fk
        FOREIGN KEY (resort_id) REFERENCES booking_system.resort (id);