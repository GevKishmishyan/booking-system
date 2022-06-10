package com.epam.bookingsystem.dto.response;

import java.util.Objects;

public class LoginResponseDTO extends ResponseDTO {

    private String jwtAccess;
    private String type = "Bearer";
    private String jwtRefresh;
    private UserResponseDTO userResponseDTO;

    public LoginResponseDTO(String jwtAccess, String jwtRefresh, UserResponseDTO userResponseDTO) {
        this.jwtAccess = jwtAccess;
        this.jwtRefresh = jwtRefresh;
        this.userResponseDTO = userResponseDTO;
    }

    public LoginResponseDTO() {
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

    public UserResponseDTO getUserDTO() {
        return userResponseDTO;
    }

    public void setUserDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "jwtAccess='" + jwtAccess + '\'' +
                ", type='" + type + '\'' +
                ", jwtRefresh='" + jwtRefresh + '\'' +
                ", userDTO=" + userResponseDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponseDTO that = (LoginResponseDTO) o;
        return Objects.equals(jwtAccess, that.jwtAccess) && Objects.equals(type, that.type) && Objects.equals(jwtRefresh, that.jwtRefresh) && Objects.equals(userResponseDTO, that.userResponseDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jwtAccess, type, jwtRefresh, userResponseDTO);
    }
}
