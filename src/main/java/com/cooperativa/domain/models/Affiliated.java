package com.cooperativa.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "affiliated")
public class Affiliated {

	private Integer id;
	private String cpf;
	private String name;

	public Affiliated(Integer id, String cpf, String name) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	@Column(name = "createdAt")
	private LocalDateTime createdAt;

	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
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
