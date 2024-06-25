package com.hutech.Nguyentansang.Validator;
import com.hutech.Nguyentansang.repository.IUserRepository;
import com.hutech.Nguyentansang.Validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernamevalidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
