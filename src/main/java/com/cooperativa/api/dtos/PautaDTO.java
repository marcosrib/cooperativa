package com.cooperativa.api.dtos;

import io.swagger.annotations.ApiModelProperty;

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
