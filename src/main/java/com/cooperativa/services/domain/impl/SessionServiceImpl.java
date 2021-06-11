package com.cooperativa.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Session;
import com.cooperativa.domain.repositories.SessionRepository;
import com.cooperativa.services.domain.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository repository;
	
	@Override
	public Session create(Session session) {
		return repository.save(session);
	}

}
