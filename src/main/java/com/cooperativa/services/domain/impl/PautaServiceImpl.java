package com.cooperativa.services.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.services.domain.PautaService;
/**
 * Service responsável por implementar a regra de negócio de uma pauta.
 * 
 * @author Marcos Ribeiro
 */
@Service
public class PautaServiceImpl implements PautaService {
	
    Logger logger = LoggerFactory.getLogger(PautaServiceImpl.class);
    
	@Autowired
	private PautaRepository repository;

	 /**
     * Método responsável por criar um pauta.
     * 
     * @author Marcos Ribeiro
     * @param Objeto - Pauta 
     * @return Objeto - Pauta.
     */
	@Override
	public Pauta create(Pauta pauta) {
	 	Pauta pautaResult = repository.save(pauta);
	 	logger.info("Pauta cadastra: {}", pautaResult);
		return pautaResult;
	}

	 /**
     * Método responsável por listas pautas.
     * 
     * @author Marcos Ribeiro
     * @param  void 
     * @return Iterable<Objeto> - Pauta.
     */
	@Override
	public Iterable<Pauta> getAll() {
		Iterable<Pauta> pautas =  repository.findAll();
		logger.info("Lista pautas: {}", pautas );
		return pautas;
	}

}
