package com.cooperativa.exceptions;

public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = -3972920913552122447L;

	public BusinessRuleException(String message) {
		super(message);
	}

}
