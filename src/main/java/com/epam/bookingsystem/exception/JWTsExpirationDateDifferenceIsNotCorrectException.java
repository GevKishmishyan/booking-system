package com.epam.bookingsystem.exception;

public class JWTsExpirationDateDifferenceIsNotCorrectException extends RuntimeException {
    public JWTsExpirationDateDifferenceIsNotCorrectException() {
    }

    public JWTsExpirationDateDifferenceIsNotCorrectException(String message) {
        super(message);
    }

    public JWTsExpirationDateDifferenceIsNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public JWTsExpirationDateDifferenceIsNotCorrectException(Throwable cause) {
        super(cause);
    }

    public JWTsExpirationDateDifferenceIsNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
