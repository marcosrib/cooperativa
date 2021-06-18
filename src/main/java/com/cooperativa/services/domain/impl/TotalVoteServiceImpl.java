package com.cooperativa.services.domain.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.reponsesdtos.VoteTotalResponseDTO;
import com.cooperativa.domain.enuns.VoteEnum;
import com.cooperativa.domain.repositories.VoteRepository;
import com.cooperativa.services.domain.TotalVoteService;
/**
 * Service responsável por implementar a regra de negócio do total de votos.
 * 
 * @author Marcos Ribeiro
 */
@Service
public class TotalVoteServiceImpl implements TotalVoteService {
	
	Logger logger = LoggerFactory.getLogger(TotalVoteServiceImpl.class);
	
	@Autowired
	private VoteRepository voteRepository;

	 /**
     * Método responsável por listar o total de votos para pauta.
     * 
     * @author Marcos Ribeiro
     * @param Integer - idPauta 
     * @return List<Objeto> - VoteTotalResponseDTO.
     */
	@Override
	public List<VoteTotalResponseDTO> calculateVote(Integer idPauta) {

		List<VoteTotalResponseDTO> totalVoteReult = voteRepository.countTotalVoteByIdPauta(idPauta).stream()
				.map(total -> new VoteTotalResponseDTO(total.getTotal(), total.getVote())).collect(Collectors.toList());

		if (totalVoteReult.isEmpty()) {
			logger.info("Se lista de {} está vazia e adiciona total 0 ", totalVoteReult);
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.SIM.toString()));
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.NAO.toString()));
		}
		Optional<VoteTotalResponseDTO> totalSimFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.SIM.toString())).findAny();
		if (!totalSimFilter.isPresent()) {
			logger.info("Se lista de {} não contém voto sim adiciona 0 no total ", totalSimFilter);
			
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.SIM.toString()));
		}
		Optional<VoteTotalResponseDTO> totalNaoFilter = totalVoteReult.stream()
				.filter(filter -> filter.getVote().equals(VoteEnum.NAO.toString())).findAny();

		if (!totalNaoFilter.isPresent()) {
			logger.info("Se lista de {} não contém voto não adiciona 0 no total ", totalSimFilter);
			totalVoteReult.add(new VoteTotalResponseDTO(0, VoteEnum.NAO.toString()));
		}
		logger.info("Lista total de votos: {} ", totalVoteReult);
		return totalVoteReult;

	}

}
