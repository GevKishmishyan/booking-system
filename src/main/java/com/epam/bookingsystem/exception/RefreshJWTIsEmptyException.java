package com.epam.bookingsystem.exception;

public class RefreshJWTIsEmptyException extends RuntimeException {
    public RefreshJWTIsEmptyException() {
    }

    public RefreshJWTIsEmptyException(String message) {
        super(message);
    }

    public RefreshJWTIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefreshJWTIsEmptyException(Throwable cause) {
        super(cause);
    }

    public RefreshJWTIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
