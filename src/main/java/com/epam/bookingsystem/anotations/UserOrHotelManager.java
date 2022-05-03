package com.epam.bookingsystem.anotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserOrHotelManagerValidator.class)
public @interface UserOrHotelManager {

String message() default  "Not valid role";
Class<?>[] groups() default { };
Class<? extends Payload> [] payload() default { };

}
