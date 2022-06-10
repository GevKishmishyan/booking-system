package com.epam.bookingsystem.services;

public interface MailService {

    void send(String to, String subject, String message);

    String generatePassword();
}
