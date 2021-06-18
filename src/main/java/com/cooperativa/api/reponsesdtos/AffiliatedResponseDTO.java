package com.cooperativa.api.reponsesdtos;

import java.time.LocalDateTime;
/**
 * Classe responseDTO do tipo AffiliatedResponseDTO contendo os dados de respostas da api affiliateds.
 * 
 * @author Marcos Ribeiro
 */
public class AffiliatedResponseDTO {

	private Integer id;
	private String cpf;
	private String name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public AffiliatedResponseDTO() {
	}

	public AffiliatedResponseDTO(Integer id, String cpf, String name, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
