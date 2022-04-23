package com.epam.bookingsystem.dto.response;

public class PasswordResetResponse {

    public PasswordResetResponse(String jwtAccess, String jwtRefresh) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
    }

    private String jwtAccess;
    private String jwtRefresh;

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
