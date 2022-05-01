package com.epam.bookingsystem.exception.dto;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String exception;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String exception,
                        String message, String details) {
        this.timestamp = timestamp;
        this.exception = exception;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails() {
    }

    public Date getCustom_timestamp() {
        return timestamp;
    }

    public void setCustom_timestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCustom_exception() {
        return exception;
    }

    public void setCustom_exception(String exception) {
        this.exception = exception;
    }

    public String getCustom_message() {
        return message;
    }

    public void setCustom_message(String message) {
        this.message = message;
    }

    public String getCustom_details() {
        return details;
    }

    public void setCustom_details(String details) {
        this.details = details;
    }
}
