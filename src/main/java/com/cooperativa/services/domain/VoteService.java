package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;

import com.cooperativa.api.dtos.VoteDTO;
import com.cooperativa.domain.models.Vote;

@Service
public interface VoteService {
	Vote vote(VoteDTO dto);
}
