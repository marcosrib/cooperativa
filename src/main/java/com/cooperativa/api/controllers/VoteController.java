package com.cooperativa.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.api.dtos.VoteDTO;
import com.cooperativa.domain.models.Vote;
import com.cooperativa.services.domain.VoteService;

@RestController
@RequestMapping("/v1/api/votes")
public class VoteController {
    @Autowired
	private VoteService service;
    
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public VoteDTO vote(@RequestBody VoteDTO dto) {
		return convertVoteToVoteDTO(service.vote(dto));
	}

	private VoteDTO convertVoteToVoteDTO(Vote vote) {
		return new VoteDTO(vote.getPauta().getId(), vote.getAffiliated().getId(), vote.getVote().toString());
		
		
	}
}
