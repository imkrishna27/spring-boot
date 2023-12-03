package com.java.springbootdemo.springBootApp.custom_annotation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPercentageValidator implements ConstraintValidator<PercentageValidator,Integer> {
    private String message;
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else {
            return true;
        }
    }

}
