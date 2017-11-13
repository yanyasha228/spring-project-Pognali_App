package net.PognaliApp.validators.svalidators;

import net.PognaliApp.models.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Regex Validator for @email of {@link User } class,
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */
@Component
public class EmailValidator {
    private static final String EMAIL_PATTERN = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public boolean validateEmail(User user) {
        Matcher matcher = pattern.matcher(user.getEmail());

        return matcher.matches();
    }
}
