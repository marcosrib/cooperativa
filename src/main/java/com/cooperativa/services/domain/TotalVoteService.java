package com.cooperativa.services.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.VoteTotalDTO;
@Service
public interface TotalVoteService {
	List<VoteTotalDTO> calculateVote(Integer idPauta);
}
