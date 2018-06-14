package ostbahn.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;


public class CurrentDate implements ConstraintValidator<CurrentDateConstraint, Date> {

    @Override
    public boolean isValid(Date d, ConstraintValidatorContext constraintValidatorContext) {
        return d.after(new Date());
    }

    @Override
    public void initialize(CurrentDateConstraint constraintAnnotation) {

    }
}
