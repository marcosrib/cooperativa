package com.cooperativa.api.reponsesdtos;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PautaResponseDTO {
	private Integer id;
	private String name;
	private LocalTime time;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public PautaResponseDTO() {
	}

	public PautaResponseDTO(Integer id, String name, LocalTime time, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
