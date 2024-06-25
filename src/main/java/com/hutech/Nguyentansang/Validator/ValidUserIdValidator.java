package com.hutech.Nguyentansang.Validator;

import com.hutech.Nguyentansang.entity.User;
import com.hutech.Nguyentansang.Validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user== null)
            return true;
        return user.getId() != null;
    }
}
