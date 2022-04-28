package com.epam.bookingsystem.exceptions;

public class JwtsExpirationDateDifferenceIsNotCorrectException extends RuntimeException {
    private String jwtAccess;
    private String jwtRefresh;

    public JwtsExpirationDateDifferenceIsNotCorrectException(String jwtAccess, String jwtRefresh) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
    }

    public String getJwtAccess() {
        return jwtAccess;
    }

    public void setJwtAccess(String jwtAccess) {
        this.jwtAccess = jwtAccess;
    }

    public String getJwtRefresh() {
        return jwtRefresh;
    }

    public void setJwtRefresh(String jwtRefresh) {
        this.jwtRefresh = jwtRefresh;
    }
}
