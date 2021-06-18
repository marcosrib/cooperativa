package com.cooperativa.services.domain.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.reponsesdtos.VoteTotalResponseDTO;
import com.cooperativa.domain.enuns.VoteEnum;
import com.cooperativa.domain.repositories.VoteRepository;
import com.cooperativa.services.domain.TotalVoteService;

@Service
public class TotalVoteServiceImpl implements TotalVoteService {
	@Autowired
	private VoteRepository voteRepository;

	@Override
	public List<VoteTotalResponseDTO> calculateVote(Integer idPauta) {

		List<VoteTotalResponseDTO> totalVoteReult = voteRepository.countTotalVoteByIdPauta(idPauta).stream()
				.map(total -> new VoteTotalResponseDTO(total.getTotal(), total.getVote())).collect(Collectors.toList());

		if (totalVoteReult.isEmpty()) {
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.SIM.toString()));
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.NAO.toString()));
		}
		Optional<VoteTotalResponseDTO> totalSimFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.SIM.toString())).findAny();
		if (!totalSimFilter.isPresent()) {
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.SIM.toString()));
		}
		Optional<VoteTotalResponseDTO> totalNaoFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.NAO.toString())).findAny();

		if (!totalNaoFilter.isPresent()) {
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.NAO.toString()));
		}

		return totalVoteReult;

	}

}
