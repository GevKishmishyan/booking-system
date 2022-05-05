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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
