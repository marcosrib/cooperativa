package com.cooperativa.domain.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime time;

	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	public Session(LocalTime time) {
		if (time == null) {
			this.time = LocalTime.of(00, 01, 00, 342123342);
		} else {
			this.time = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond(), 342123342);
		}

	}

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}

	public LocalTime getTime() {
		return time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
