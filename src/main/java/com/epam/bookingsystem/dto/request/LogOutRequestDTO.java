package com.epam.bookingsystem.dto.request;

public class LogOutRequestDTO {

    private String jwtRefresh;

    public String getJwtRefresh() {
        return jwtRefresh;
    }

    public void setJwtRefresh(String jwtRefresh) {
        this.jwtRefresh = jwtRefresh;
    }

}
