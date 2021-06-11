package com.cooperativa.api.dtos;

public class AffiliatedDTO {
	private Integer id;
	private String cpf;
	private String name;
	
	public AffiliatedDTO(Integer id, String cpf, String name) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
