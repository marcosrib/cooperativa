package com.cooperativa.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.dtos.PautaDTO;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.services.domain.PautaService;

@RestController
@RequestMapping("/v1/api/pautas")
public class PautaController {
	
	
	@Autowired
	private PautaService service;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public PautaDTO create(@RequestBody PautaDTO dto) {
		Pauta pauta = service.create(convertPautaDTOToPauta(dto));
	   return convertPautaToPautaDTO(pauta);
	}
	
	private Pauta convertPautaDTOToPauta(PautaDTO dto) {
		return new Pauta(dto.getName());
	}
	
	private PautaDTO convertPautaToPautaDTO(Pauta pauta) {
		return new PautaDTO(pauta.getId(), pauta.getName());
	}
}
