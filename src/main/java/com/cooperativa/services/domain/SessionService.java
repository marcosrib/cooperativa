package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Session;

@Service
public interface SessionService {
	Session create(Session session, Integer idPauta);
}
