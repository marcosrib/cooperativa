package com.cooperativa.api.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.ResponseErrors;
import com.cooperativa.api.dtos.AffiliatedDTO;
import com.cooperativa.api.reponsesdtos.AffiliatedResponseDTO;
import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.services.domain.AffiliatedService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;;

@RestController
@RequestMapping("/api/")
public class AffiliatedController {

	
	@Autowired
	private AffiliatedService service;

	@ApiOperation("Cria novo afialiado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Novo afialiado criado com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@PostMapping("v1/affiliateds")
	@ResponseStatus(HttpStatus.CREATED)
	public AffiliatedResponseDTO create(@RequestBody AffiliatedDTO dto) {
		Affiliated affiliated = service.create(convertAffiliatedDTOToAffiliated(dto));
		return convertAffiliatedToAffiliatedDTO(affiliated);
	}

	@ApiOperation("Lista afiliados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de afiliados."),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@GetMapping("v1/affiliatedss")
	@ResponseStatus(HttpStatus.OK)
	public List<AffiliatedResponseDTO> list() {
		Iterable<Affiliated> affiliateds = service.getAll();
		return convertListAffiliatedToAffiliatedDTO(affiliateds);
	}

	private Affiliated convertAffiliatedDTOToAffiliated(AffiliatedDTO dto) {
		return new Affiliated(null, dto.getCpf(), dto.getName());
	}

	private AffiliatedResponseDTO convertAffiliatedToAffiliatedDTO(Affiliated affiliated) {
		return new AffiliatedResponseDTO(affiliated.getId(), affiliated.getCpf(), affiliated.getName(),
				affiliated.getCreatedAt(), affiliated.getUpdatedAt());
	}

	private List<AffiliatedResponseDTO> convertListAffiliatedToAffiliatedDTO(Iterable<Affiliated> affiliateds) {
		return StreamSupport.stream(affiliateds.spliterator(), false)
				.map(affiliated -> new AffiliatedResponseDTO(affiliated.getId(), affiliated.getCpf(),
						affiliated.getName(), affiliated.getCreatedAt(), affiliated.getUpdatedAt()))
				.collect(Collectors.toList());

	}

}
