package com.cooperativa.exceptions;
/**
 * Classe exception do tipo NotFoundException para tratar e exibir mensagem das exeções personalizadas
 * 
 * @author Marcos Ribeiro
 */
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444017073161864100L;

	public NotFoundException(String message) {
		super(message);
	}

}
