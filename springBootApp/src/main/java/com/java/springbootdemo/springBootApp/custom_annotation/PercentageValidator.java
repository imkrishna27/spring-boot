package com.java.springbootdemo.springBootApp.custom_annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CheckPercentageValidator.class)
public @interface PercentageValidator {
    String message() default "not empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
