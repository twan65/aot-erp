package jp.co.aoterp.validation;

import jp.co.aoterp.validation.validator.DateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = DateFormatValidator.class)
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormatValid {

    String message() default "";
    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        DateFormatValid[] values();
    }
}
