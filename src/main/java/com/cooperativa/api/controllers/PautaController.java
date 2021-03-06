package com.cooperativa.api.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/")
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
	@PostMapping("/v1/pautas")
	@ResponseStatus(HttpStatus.CREATED)
	public PautaResponseDTO create(@RequestBody PautaDTO dto) {
		Pauta pauta = service.create(convertPautaDTOToPauta(dto));
		return convertPautaToPautaDTO(pauta);
	}
	
	@ApiOperation("Lista pautas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de afiliados."),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@GetMapping("v1/pautas")
	@ResponseStatus(HttpStatus.OK)
	public List<PautaResponseDTO> list() {
		Iterable<Pauta> pautas = service.getAll();
		return convertListPautaToPautaResponseDTO(pautas);
	}

	@ApiOperation("Inicia uma sess??o")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nova sess??o criado com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@PatchMapping("/v1/pautas/start-session")
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
	
	private List<PautaResponseDTO> convertListPautaToPautaResponseDTO(Iterable<Pauta> pautas) {
		return StreamSupport.stream(pautas.spliterator(), false)
				.map(pauta ->  new PautaResponseDTO(pauta.getId(),pauta.getName(), pauta.getTime(), pauta.getCreatedAt(), pauta.getUpdatedAt()))
				.collect(Collectors.toList());

	}
}
