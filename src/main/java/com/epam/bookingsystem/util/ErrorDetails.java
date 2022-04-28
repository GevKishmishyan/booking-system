package com.epam.bookingsystem.util;

import java.util.Date;

public class ErrorDetails {
    private Date custom_timestamp;
    private String custom_exception;
    private String custom_message;
    private String custom_details;

    public ErrorDetails(Date custom_timestamp, String custom_exception,
                        String custom_message, String custom_details) {
        this.custom_timestamp = custom_timestamp;
        this.custom_exception = custom_exception;
        this.custom_message = custom_message;
        this.custom_details = custom_details;
    }

    public ErrorDetails() {
    }

    public Date getCustom_timestamp() {
        return custom_timestamp;
    }

    public void setCustom_timestamp(Date custom_timestamp) {
        this.custom_timestamp = custom_timestamp;
    }

    public String getCustom_exception() {
        return custom_exception;
    }

    public void setCustom_exception(String custom_exception) {
        this.custom_exception = custom_exception;
    }

    public String getCustom_message() {
        return custom_message;
    }

    public void setCustom_message(String custom_message) {
        this.custom_message = custom_message;
    }

    public String getCustom_details() {
        return custom_details;
    }

    public void setCustom_details(String custom_details) {
        this.custom_details = custom_details;
    }
}
