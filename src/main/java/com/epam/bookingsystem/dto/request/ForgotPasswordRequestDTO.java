package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ForgotPasswordRequestDTO {
    private String code;
    @Size(min = 6,max = 24)
    @NotBlank
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Size(min = 6,max = 24)
    @NotBlank
    @NotEmpty(message = "*Please provide your password")
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
