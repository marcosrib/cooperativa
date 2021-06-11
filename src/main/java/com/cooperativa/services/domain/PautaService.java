package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;
import com.cooperativa.domain.models.Pauta;

@Service
public interface PautaService {
	Pauta create(Pauta pauta);
}
