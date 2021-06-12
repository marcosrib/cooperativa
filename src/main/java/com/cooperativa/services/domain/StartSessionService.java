package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.PautaDTO;
import com.cooperativa.domain.models.Pauta;

@Service
public interface StartSessionService {
	Pauta startSession(PautaDTO dto);
}
