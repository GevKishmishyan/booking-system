package com.epam.bookingsystem.exception;

public class IncorrectCurrentPasswordException extends RuntimeException {
    public IncorrectCurrentPasswordException() {
    }

    public IncorrectCurrentPasswordException(String message) {
        super(message);
    }

    public IncorrectCurrentPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCurrentPasswordException(Throwable cause) {
        super(cause);
    }

    public IncorrectCurrentPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
