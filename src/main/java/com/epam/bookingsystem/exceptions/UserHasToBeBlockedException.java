package com.epam.bookingsystem.exceptions;

import com.epam.bookingsystem.entitys.User;

public class UserHasToBeBlockedException extends RuntimeException {

    private String jwtAccess;
    private String jwtRefresh;

    public UserHasToBeBlockedException(String jwtAccess, String jwtRefresh) {
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
