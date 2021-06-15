package com.cooperativa.domain.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "pauta")
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime time;
	
	@Column(name = "sessionStarted")
	private  boolean sessionStarted;
	

	@OneToMany(mappedBy = "pauta", fetch = FetchType.LAZY)
	private List<Vote> vote;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
	public LocalDateTime getDateSessionStarted() {
		return dateSessionStarted;
	}

	public void setDateSessionStarted(LocalDateTime dateSessionStarted) {
		this.dateSessionStarted = dateSessionStarted;
	}

	private LocalDateTime dateSessionStarted;
	
	public Pauta() {}

	public Pauta(String name) {
		this.name = name;
	}

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public boolean isSessionStarted() {
		return sessionStarted;
	}

	public void setSessionStarted(boolean sessionStarted) {
		this.sessionStarted = sessionStarted;
	}

	
}
