package com.cooperativa.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.services.domain.PautaService;

@Service
public class PautaServiceImpl implements PautaService {

	@Autowired
	private PautaRepository repository;

	@Override
	public Pauta create(Pauta pauta) {
		return repository.save(pauta);
	}

}
