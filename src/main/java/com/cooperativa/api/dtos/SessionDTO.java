package com.cooperativa.api.dtos;

public class SessionDTO {
	
	
	private Integer id;
	private String time;


	public SessionDTO(Integer id, String time) {
		this.id = id;
		this.time = time;
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

}
