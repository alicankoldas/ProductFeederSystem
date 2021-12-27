package com.productfeedersystem.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;

public class EnumValidator implements ConstraintValidator<EnumConstraint, String> {

    private List<String> enumValues;

    @Override
    public void initialize(EnumConstraint constraintAnnotation) {

        Enum[] values = constraintAnnotation.enumClass().getEnumConstants();
        enumValues = new ArrayList<>();
        for (Enum value : values) {
            enumValues.add(value.name());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() < 1) {
            return false;
        }
        return enumValues.contains(value.toUpperCase());
    }
}
