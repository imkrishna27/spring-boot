package com.java.springbootdemo.springBootApp.custom_annotation;

import jakarta.validation.*;

import java.util.Set;

public class TestCustomValidation {
    public static void main(String[] args) throws NoSuchFieldException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Subject subject = new Subject();

        Set<ConstraintViolation<Subject>> violations = validator.validate(subject);
        for (ConstraintViolation<Subject> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

    public static void getSubject(@Valid Subject subject) {
        System.out.println(subject);
    }
}
