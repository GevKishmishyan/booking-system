package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.validation.annotation.ValidPassword;

public class ForgotPasswordRequestDTO {
    private String code;
    @ValidPassword
    private String password;
    @ValidPassword
    private String confirmPassword;

    public ForgotPasswordRequestDTO(String code, String password, String confirmPassword) {
        this.code = code;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
