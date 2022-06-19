package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.validation.annotation.ValidPassword;

import javax.validation.constraints.NotBlank;

public class PasswordResetRequest extends RequestDto {

    @NotBlank(message = "Please provide your password")
    String currentPassword;
    @ValidPassword
    String newPassword;
    @ValidPassword
    String conformNewPassword;

    public PasswordResetRequest(String currentPassword, String newPassword, String conformNewPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.conformNewPassword = conformNewPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConformNewPassword() {
        return conformNewPassword;
    }

    public void setConformNewPassword(String conformNewPassword) {
        this.conformNewPassword = conformNewPassword;
    }
}
