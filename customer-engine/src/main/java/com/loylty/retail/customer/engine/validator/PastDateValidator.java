package com.loylty.retail.customer.engine.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PastDateValidator implements ConstraintValidator<PastDate, String>{

	private String pattern;
	
	@Override
	public void initialize(PastDate constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) 
			return true;
		try {
			Date received = new SimpleDateFormat(pattern).parse(value);
			return received.getTime() < System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
