package com.hutech.Nguyentansang.Validator.annotation;

import com.hutech.Nguyentansang.Validator.ValidUsernamevalidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernamevalidator.class)
public @interface ValidUsername {
    String message() default "Username already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
