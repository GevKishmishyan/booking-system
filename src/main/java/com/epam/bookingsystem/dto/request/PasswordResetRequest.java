package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;

public class PasswordResetRequest {

    // todo add more validation annotations
    @NotBlank
    String currentPassword;

    // todo add more validation annotations
    @NotBlank
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
