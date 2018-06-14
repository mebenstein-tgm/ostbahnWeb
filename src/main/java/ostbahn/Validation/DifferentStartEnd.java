package ostbahn.Validation;

import ostbahn.Entity.StartEndBahnhof;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DifferentStartEnd implements ConstraintValidator<DifferentStartEndConstraint, StartEndBahnhof> {

    @Override
    public boolean isValid(StartEndBahnhof startEndBahnhof, ConstraintValidatorContext constraintValidatorContext) {
        return startEndBahnhof.getStart().getName() != startEndBahnhof.getEnde().getName();
    }

    @Override
    public void initialize(DifferentStartEndConstraint constraintAnnotation) {

    }
}
