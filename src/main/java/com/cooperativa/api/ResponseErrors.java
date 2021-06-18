package com.cooperativa.api;

import java.util.Arrays;
import java.util.List;
/**
 * Classe responseErrors do tipo ResponseErrors contendo os dados de resposta para padronização de erros das apis.
 * 
 * @author Marcos Ribeiro
 */
public class ResponseErrors {

	private List<String> errors;

	public ResponseErrors(String messageError) {
		this.errors = Arrays.asList(messageError);
	}

	public List<String> getErrors() {
		return errors;
	}
}
