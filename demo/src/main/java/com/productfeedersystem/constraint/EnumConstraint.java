package com.productfeedersystem.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
@Documented
public @interface EnumConstraint {
    String message() default "";
    Class<? extends Enum> enumClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
