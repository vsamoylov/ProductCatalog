package com.springapp.mvc.validator;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Max on 09.11.2016.
 */
@Component
public class UserFormValidator implements Validator {

    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.userForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");

        if (!emailValidator.valid(user.getEmail())) {
            errors.rejectValue("email", "Pattern.userForm.email");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }

        if (user.getGrants() == null || (user.getGrants() != null && user.getGrants().size() < 1)) {
            errors.rejectValue("grants", "Valid.userForm.grants");
        }
    }
}
