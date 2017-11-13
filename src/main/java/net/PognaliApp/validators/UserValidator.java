package net.PognaliApp.validators;

import net.PognaliApp.models.User;
import net.PognaliApp.services.UserService;
import net.PognaliApp.validators.svalidators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link User} class,
 * implements {@link Validator} interface.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getUsername().length() < 8 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        if (!emailValidator.validateEmail(user)) {
            errors.rejectValue("email", "Correct.userForm.email");

        }
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        if (user.getPassword().length() < 5 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}
