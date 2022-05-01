package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.repository.JWTBlacklistDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    final
    JWTBlacklistDAO jwtBlacklistDAO;

    public TestController(JWTBlacklistDAO jwtBlacklistDAO) {
        this.jwtBlacklistDAO = jwtBlacklistDAO;
    }

    /**
     * This URL is accessible to everyone, regardless of whether it is authenticated or not
     *
     * @return just a text "Public Content."
     */
    @GetMapping("/permit_all")
    public String permitAll() {
        log.info("permit all");
        return "Public Content.";
    }

    /**
     * Only users with the USER , MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "User"
     */
    @GetMapping("/user")
    public String userAccess() {
        return "User";
    }

    /**
     * Only users with the HOTEL_MANAGER , MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "Moderator"
     */
    @GetMapping("/hotel_manager")
    public String hotelManagerAccess() {
        return "Hotel Manager";
    }

    /**
     * Only users with the MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "Moderator"
     */
    @GetMapping("/moderator")
    public String moderatorAccess() {
        return "Moderator";
    }

    /**
     * Only a user with role ADMIN has access to this URL
     *
     * @return just a text "Admin"
     */
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin";
    }

}
