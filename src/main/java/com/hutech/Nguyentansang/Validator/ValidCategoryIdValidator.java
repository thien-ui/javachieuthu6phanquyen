package com.hutech.Nguyentansang.Validator;

import com.hutech.Nguyentansang.Validator.annotation.ValidCategoryId;
import com.hutech.Nguyentansang.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;

    }

}
