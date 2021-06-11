package com.cooperativa.services.domain.impl;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.models.Session;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.domain.repositories.SessionRepository;
import com.cooperativa.services.domain.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository repository;

	@Autowired
	private PautaRepository pautaRepository;

	@Override
	public Session create(Session session, Integer idPauta) {
		session.setPauta(
				pautaRepository.findById(idPauta)
				.orElseThrow(() -> new RuntimeException("Pauta not found")));
		return repository.save(session);
	}

}
