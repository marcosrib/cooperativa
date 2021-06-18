package com.cooperativa.api.dtos;

import io.swagger.annotations.ApiModelProperty;
/**
 * Classe DTO do tipo PautaDTO contendo os dados de entrada da api pautas.
 * 
 * @author Marcos Ribeiro
 */
public class PautaDTO {
	@ApiModelProperty(value="nome da pauta", required = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
