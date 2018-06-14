package ostbahn.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class BahnhofName implements ConstraintValidator<BahnhofNameConstraint, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[A-Za-z-]{3,150}");
    }

    @Override
    public void initialize(BahnhofNameConstraint constraintAnnotation) {

    }
}
