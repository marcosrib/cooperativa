package com.cooperativa.services.domain.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.StartSessionDTO;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.exceptions.NotFoundException;
import com.cooperativa.services.domain.StartSessionService;
/**
 * Service responsável por implementar a regra de negócio para startar uma sessão.
 * 
 * @author Marcos Ribeiro
 */
@Service
public class StarteSessionServiceImpl implements StartSessionService {
	
	Logger logger = LoggerFactory.getLogger(StarteSessionServiceImpl.class);
	
	@Autowired
	private PautaRepository pautaRepository;
	 /**
     * Método responsável por startar uma sessão na pauta.
     * 
     * @author Marcos Ribeiro
     * @param Objeto - StartSessionDTO 
     * @return Objeto - Pauta.
     */
	@Override
	public Pauta startSession(StartSessionDTO dto) {

		return pautaRepository.findById(dto.getIdPauta()).map(pauta -> {
			if (pauta.isSessionStarted()) {
				logger.info("Sessão já está inicializada");
				throw new BusinessRuleException("Session already initialized");
			}
			pauta.setSessionStarted(true);
			pauta.setDateSessionStarted(LocalDateTime.now());
			if (dto.getTime() == null || "".equals(dto.getTime()) || dto.getTime().equals("00:00:00") ) {
				pauta.setTime(LocalTime.of(00, 01, 00, 342123342));
			} else {
				LocalTime time = LocalTime.parse(dto.getTime());
				pauta.setTime(LocalTime.of(time.getHour(), time.getMinute(), time.getSecond(), 342123342));
			}
			pautaRepository.save(pauta);
			logger.info("Puata cadastrada!: ", pauta.getName());
			return pauta;
		}).orElseThrow(() -> new NotFoundException("Pauta not found"));
	}

}
