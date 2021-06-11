package com.cooperativa.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.dtos.AffiliatedDTO;
import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.services.domain.AffiliatedService;

@RestController
@RequestMapping("/v1/api/affiliateds")
public class AffiliatedController {
	
	@Autowired
	private AffiliatedService service;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public AffiliatedDTO create(@RequestBody AffiliatedDTO dto) {
		Affiliated affiliated = service.create(convertAffiliatedDTOToAffiliated(dto));
		return convertAffiliatedToAffiliatedDTO(affiliated);
	}
	
	private Affiliated convertAffiliatedDTOToAffiliated(AffiliatedDTO dto) {
		return new Affiliated(null,dto.getCpf(), dto.getName());
	}
	
	private AffiliatedDTO convertAffiliatedToAffiliatedDTO(Affiliated affiliated) {
		return new AffiliatedDTO(affiliated.getId(),affiliated.getCpf(), affiliated.getName());
	}
	
}
