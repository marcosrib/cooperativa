package com.cooperativa.services.domain.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.VoteDTO;
import com.cooperativa.domain.enuns.VoteEnum;
import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.models.Vote;
import com.cooperativa.domain.repositories.AffiliatedRepository;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.domain.repositories.VoteRepository;
import com.cooperativa.exceptions.NotFoundException;
import com.cooperativa.services.domain.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository repository;

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private AffiliatedRepository affiliatedRepository;

	@Override
	public Vote vote(VoteDTO dto) {
		Optional<Pauta> pauta = pautaRepository.findById(dto.getPautaId());
		if (!pauta.isPresent()) {
			throw new NotFoundException("Pauta not found");
		}

		Optional<Affiliated> affiliated = affiliatedRepository.findById(dto.getAffiliatedId());
		if (!affiliated.isPresent()) {
			throw new NotFoundException("Affiliated not found");
		}

		Optional<Vote> vote = repository.findByPautaAndAffiliated(pauta.get(), affiliated.get());
		if (vote.isPresent()) {
			throw new NotFoundException("Vote has already been taken");
		}		
		
		return repository.save(new Vote(VoteEnum.valueOf(dto.getVote()), pauta.get(), affiliated.get()));
	}

}
