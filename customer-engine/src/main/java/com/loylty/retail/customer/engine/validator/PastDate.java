package com.loylty.retail.customer.engine.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastDateValidator.class)
@Documented
public @interface PastDate {

	String message() default "{message.key}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern();
}
