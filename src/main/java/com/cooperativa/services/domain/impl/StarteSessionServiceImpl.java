package com.cooperativa.services.domain.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.StartSessionDTO;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.exceptions.NotFoundException;
import com.cooperativa.services.domain.StartSessionService;

@Service
public class StarteSessionServiceImpl implements StartSessionService {

	@Autowired
	private PautaRepository pautaRepository;

	@Override
	public Pauta startSession(StartSessionDTO dto) {

		return pautaRepository.findById(dto.getIdPauta()).map(pauta -> {
			if (pauta.isSessionStarted()) {
				throw new BusinessRuleException("Pauta already initialized");
			}
			pauta.setSessionStarted(true);
			pauta.setDateSessionStarted(LocalDateTime.now());
			if (dto.getTime() == null || "".equals(dto.getTime())) {
				pauta.setTime(LocalTime.of(00, 01, 00, 342123342));
			} else {
				LocalTime time = LocalTime.parse(dto.getTime());
				pauta.setTime(LocalTime.of(time.getHour(), time.getMinute(), time.getSecond(), 342123342));
			}
			pautaRepository.save(pauta);
			return pauta;
		}).orElseThrow(() -> new NotFoundException("Pauta not found"));
	}

}
