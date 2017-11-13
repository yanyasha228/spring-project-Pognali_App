package net.PognaliApp.validators;

import net.PognaliApp.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 * Validator for check code of {@link User } class,
 * implements {@link Validator} interface.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */

@Component
public class CheckCodeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkcode", "Required");
        if(!user.getGencode().equals(user.getCheckcode()))
        {
            errors.rejectValue("checkcode", "Correct.userForm.checkcode");
        }
    }
}
