package com.cooperativa.domain.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.models.Vote;
@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer>{
	Optional<Vote> findByPautaAndAffiliated(Pauta pauta, Affiliated affiliated);
}
