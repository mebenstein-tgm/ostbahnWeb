package ostbahn.Validation;

import ostbahn.Validation.DifferentStartEnd;
import ostbahn.Entity.StartEndBahnhof;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DifferentStartEnd.class)
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DifferentStartEndConstraint {
    String message() default "Start and Endbahnhof cannot be the same";
    Class<?>[] groups() default {};
    Class<? extends StartEndBahnhof>[] payload() default {};
}
