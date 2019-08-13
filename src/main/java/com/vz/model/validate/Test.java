package com.vz.model.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vz.model.VzoomModelCloner;
import com.vz.model.mq.common.two.MQMessage;

public class Test {
	public static void main(String[] args) {
		MQMessage mqMessage = VzoomModelCloner.getMQMessageClone();
		List<String> validate = validate(mqMessage);
	     validate.forEach(row -> {
	         System.out.println(row.toString());
	     });
	}

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	 
	public static <T> List<String> validate(T t) {
	     Validator validator = factory.getValidator();
	     Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
	 
	     List<String> messageList = new ArrayList<>();
	     for (ConstraintViolation<T> constraintViolation : constraintViolations) {
	         messageList.add(constraintViolation.getMessage());
	     }
	     return messageList;
	 }
}
