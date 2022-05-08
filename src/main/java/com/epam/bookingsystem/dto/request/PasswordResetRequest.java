package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordResetRequest {

    @NotBlank(message = "Please provide your password")
    @Size(min = 6, max = 24)
    String currentPassword;

    @NotBlank(message = "Please provide new password to reset your password")
    @Size(min = 6, max = 24)
    String newPassword;

    @NotBlank(message = "Please conform your new password")
    @Size(min = 6, max = 24)
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
