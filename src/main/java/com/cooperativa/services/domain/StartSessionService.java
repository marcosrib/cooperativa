package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.StartSessionDTO;
import com.cooperativa.domain.models.Pauta;

@Service
public interface StartSessionService {
	Pauta startSession(StartSessionDTO dto);
}
