package aa;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by xuwei on 2017/2/15.
 */
public class UserValidat implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
