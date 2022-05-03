package com.epam.bookingsystem.anotations;

import com.epam.bookingsystem.model.enums.Role;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


import static com.epam.bookingsystem.model.enums.Role.HOTEL_MANAGER;
import static com.epam.bookingsystem.model.enums.Role.USER;

public class UserOrHotelManagerValidator implements ConstraintValidator<UserOrHotelManager, Role> {
    List<Role> roles= Arrays.asList(USER,HOTEL_MANAGER);
    @Override
    public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
        return roles.contains(role);
    }
}
