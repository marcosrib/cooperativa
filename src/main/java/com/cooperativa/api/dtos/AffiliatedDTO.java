package com.cooperativa.api.dtos;

import io.swagger.annotations.ApiModelProperty;

public class AffiliatedDTO {
	@ApiModelProperty(value="Cpf do afiliado", required = true)
	private String cpf;
	@ApiModelProperty(value="nome do afiliado", required = true)
	private String name;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
