package com.cooperativa.api.dtos;

public class SessionDTO {
	
	private Integer id;
	private String time;
	private Integer idPauta;

	public SessionDTO(Integer id, String time, Integer idPauta) {
		this.id = id;
		this.time = time;
		this.idPauta = idPauta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Integer idPauta) {
		this.idPauta = idPauta;
	}
	

}
