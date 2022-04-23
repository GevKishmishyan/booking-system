package com.epam.bookingsystem.dto.request;

public class PasswordResetRequest {
    // todo add validation annotations
    String currentPassword;
    // todo add validation annotations
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
