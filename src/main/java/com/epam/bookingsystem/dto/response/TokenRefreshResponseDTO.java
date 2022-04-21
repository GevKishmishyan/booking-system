package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.dto.UserDTO;

import java.util.Objects;

public class TokenRefreshResponseDTO {

    private String jwtAccess;
    private String type = "Bearer";
    private String jwtRefresh;

    public TokenRefreshResponseDTO(String jwtAccess, String jwtRefresh) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
    }

    public TokenRefreshResponseDTO() {
    }

    public String getJwtAccess() {
        return jwtAccess;
    }

    public void setJwtAccess(String jwtAccess) {
        this.jwtAccess = jwtAccess;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJwtRefresh() {
        return jwtRefresh;
    }

    public void setJwtRefresh(String jwtRefresh) {
        this.jwtRefresh = jwtRefresh;
    }


}
