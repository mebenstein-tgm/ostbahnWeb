package ostbahn.Validation;

import ostbahn.Entity.StartEndBahnhof;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CorrectEmail implements ConstraintValidator<CorrectEmailConstraint, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[a-z0-9.]+@[a-z0-9]+\\.[a-z0-9]+");
    }

    @Override
    public void initialize(CorrectEmailConstraint constraintAnnotation) {

    }
}
