package com.cooperativa.api;

import java.util.Arrays;
import java.util.List;

public class ResponseErrors {

	private List<String> errors;

	public ResponseErrors(String messageError) {
		this.errors = Arrays.asList(messageError);
	}

	public List<String> getErrors() {
		return errors;
	}
}
