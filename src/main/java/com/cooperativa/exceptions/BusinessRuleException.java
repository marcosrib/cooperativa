package com.cooperativa.exceptions;
/**
 * Classe exception do tipo BusinessRuleException para tratar e exibir mensagem das exeções personalizadas
 * 
 * @author Marcos Ribeiro
 */
public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = -3972920913552122447L;

	public BusinessRuleException(String message) {
		super(message);
	}

}
