package com.cooperativa.services.domain.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.VoteDTO;
import com.cooperativa.api.dtos.VoteTotalDTO;
import com.cooperativa.domain.enuns.VoteEnum;
import com.cooperativa.domain.repositories.VoteRepository;
import com.cooperativa.domain.repositories.VoteRepository.VoteTotalInterface;
import com.cooperativa.services.domain.TotalVoteService;

@Service
public class TotalVoteServiceImpl implements TotalVoteService {
	@Autowired
	private VoteRepository voteRepository;

	@Override
	public List<VoteTotalDTO> calculateVote(Integer idPauta) {

		List<VoteTotalDTO> totalVoteReult = voteRepository.countTotalVoteByIdPauta(idPauta).stream()
				.map(total -> new VoteTotalDTO(total.getTotal(), total.getVote())).collect(Collectors.toList());

		if (totalVoteReult.isEmpty()) {
			totalVoteReult.add(new VoteTotalDTO(0, VoteEnum.SIM.toString()));
			totalVoteReult.add(new VoteTotalDTO(0, VoteEnum.NAO.toString()));
		}
		Optional<VoteTotalDTO> totalSimFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.SIM.toString())).findAny();
		if (!totalSimFilter.isPresent()) {
			totalVoteReult.add(new VoteTotalDTO(0, VoteEnum.SIM.toString()));
		}
		Optional<VoteTotalDTO> totalNaoFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.NAO.toString())).findAny();

		if (!totalNaoFilter.isPresent()) {
			totalVoteReult.add(new VoteTotalDTO(0, VoteEnum.NAO.toString()));
		}

		return totalVoteReult;

	}

}
