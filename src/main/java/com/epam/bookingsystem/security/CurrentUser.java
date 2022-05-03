package com.epam.bookingsystem.security;

import com.epam.bookingsystem.model.Users;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Users user;

    public CurrentUser(Users user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                user.isNotBlocked(), AuthorityUtils.createAuthorityList("ROLE_" + user.getRole().name()));
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

}