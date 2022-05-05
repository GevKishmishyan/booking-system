package com.epam.bookingsystem.security;

import com.epam.bookingsystem.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {

        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                !user.isBlocked(), AuthorityUtils.createAuthorityList("ROLE_" + user.getRole().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}