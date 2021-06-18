package com.cooperativa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.ResponseErrors;
import com.cooperativa.api.dtos.VoteDTO;
import com.cooperativa.api.reponsesdtos.VoteTotalResponseDTO;
import com.cooperativa.domain.models.Vote;
import com.cooperativa.services.domain.TotalVoteService;
import com.cooperativa.services.domain.VoteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/api/votes")
public class VoteController {
    @Autowired
	private VoteService service;
    
    @Autowired
    private TotalVoteService totalVoteService;
    @ApiOperation("Realiza o voto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Voto realizado com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public VoteDTO vote(@RequestBody VoteDTO dto) {
		return convertVoteToVoteDTO(service.vote(dto));
	}
    
    @ApiOperation("Exibe total do votos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Votoas recuperados com sucesso!"),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseErrors.class),
			@ApiResponse(code = 404, message = "Not found", response = ResponseErrors.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseErrors.class) })
	@GetMapping("total/{idPauta}")
	@ResponseStatus(HttpStatus.OK)
	public List<VoteTotalResponseDTO> totalVote(@PathVariable("idPauta") Integer idPauta) {
		return totalVoteService.calculateVote(idPauta);
	}

	
	
	private VoteDTO convertVoteToVoteDTO(Vote vote) {
		return new VoteDTO(vote.getPauta().getId(), vote.getAffiliated().getId(), vote.getVote().toString());
		
		
	}
}
