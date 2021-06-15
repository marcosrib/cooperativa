package com.cooperativa.api.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cooperativa.api.ResponseErrors;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.exceptions.NotFoundException;



@RestControllerAdvice
public class ApplicationControllerAdvice {
	@ExceptionHandler(BusinessRuleException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseErrors handlerBusinessRuleException(BusinessRuleException ex) {
		String messageError = ex.getMessage();
		return new ResponseErrors(messageError);
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseErrors handlerNotFoundException(NotFoundException ex) {
		String messageError = ex.getMessage();
		return new ResponseErrors(messageError);
	}
}