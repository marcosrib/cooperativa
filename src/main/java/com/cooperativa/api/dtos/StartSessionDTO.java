package com.cooperativa.api.dtos;

import io.swagger.annotations.ApiModelProperty;
/**
 * Classe DTO do tipo StartSessionDTO contendo os dados de entrada da api pautas/start-session.
 * 
 * @author Marcos Ribeiro
 */
public class StartSessionDTO {

	@ApiModelProperty(value = "Id pauta", required = true)
	private Integer idPauta;
	@ApiModelProperty(value = "Tempo da sessão, formato= 00:00:00", required = true)
	private String time;
	public Integer getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(Integer idPauta) {
		this.idPauta = idPauta;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
