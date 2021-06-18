package com.cooperativa.services.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooperativa.api.reponsesdtos.VoteTotalResponseDTO;
@Service
public interface TotalVoteService {
	List<VoteTotalResponseDTO> calculateVote(Integer idPauta);
}
