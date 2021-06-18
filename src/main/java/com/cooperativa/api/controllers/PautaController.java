package com.cooperativa.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.ResponseErrors;
import com.cooperativa.api.dtos.PautaDTO;
import com.cooperativa.api.dtos.StartSessionDTO;
import com.cooperativa.api.reponsesdtos.PautaResponseDTO;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.services.domain.PautaService;
import com.cooperativa.services.domain.StartSessionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/api/pautas")
public class PautaController {

	@Autowired
	private PautaService service;
	
	@Autowired
	private StartSessionService startSessionService;

	@ApiOperation("Cria nova pauta")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Nova pauta criado com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public PautaResponseDTO create(@RequestBody PautaDTO dto) {
		Pauta pauta = service.create(convertPautaDTOToPauta(dto));
		return convertPautaToPautaDTO(pauta);
	}

	@ApiOperation("Inicia uma sessão")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nova sessão criado com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@PatchMapping("start-session")
	@ResponseStatus(HttpStatus.OK)
	public Pauta startSession(@RequestBody StartSessionDTO dto){
		return startSessionService.startSession(dto);
	}
		
	private Pauta convertPautaDTOToPauta(PautaDTO dto) {
		return new Pauta(dto.getName());
	}

	private PautaResponseDTO convertPautaToPautaDTO(Pauta pauta) {

		return new PautaResponseDTO(pauta.getId(),pauta.getName(), pauta.getTime(), pauta.getCreatedAt(), pauta.getUpdatedAt());
	}
}
