package com.epam.bookingsystem.exception;

public class JWTIsInBlacklistException extends RuntimeException {
    public JWTIsInBlacklistException() {
    }

    public JWTIsInBlacklistException(String message) {
        super(message);
    }

    public JWTIsInBlacklistException(String message, Throwable cause) {
        super(message, cause);
    }

    public JWTIsInBlacklistException(Throwable cause) {
        super(cause);
    }

    public JWTIsInBlacklistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
