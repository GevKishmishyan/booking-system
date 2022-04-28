package com.epam.bookingsystem.security;


import com.epam.bookingsystem.entitys.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    // todo be replaced with mapper
    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                user.isNotBlocked(), AuthorityUtils.createAuthorityList("ROLE_" + user.role.name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}