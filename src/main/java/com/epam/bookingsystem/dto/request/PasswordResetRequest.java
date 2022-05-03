package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordResetRequest {

    @NotBlank
    @Size(min = 6, max = 24)
    String currentPassword;

    @NotBlank
    @Size(min = 6, max = 24)
    String newPassword;

    public PasswordResetRequest(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public PasswordResetRequest() {
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
}
