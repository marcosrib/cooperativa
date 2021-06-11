package com.cooperativa.api.controllers;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.dtos.SessionDTO;
import com.cooperativa.domain.models.Session;
import com.cooperativa.services.domain.SessionService;

@RestController
@RequestMapping("/v1/api/sessions")
public class SessionController {
	
    @Autowired
	private SessionService service;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public SessionDTO create(@RequestBody SessionDTO dto) {
		Session session = convertSessionDTOToSession(dto);
		return convertSessionToSessionDTO(service.create(session));
	}

	private Session convertSessionDTOToSession(SessionDTO dto) {
		if("".equals(dto.getTime()) || dto.getTime() == null ) {
			return new Session(null);
		}
		return new Session(LocalTime.parse(dto.getTime()));
	}

	private SessionDTO convertSessionToSessionDTO(Session session) {
		return new SessionDTO(session.getId(), session.getTime().toString());
	}
}
