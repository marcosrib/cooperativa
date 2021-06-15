package com.cooperativa.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.models.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {
	Optional<Vote> findByPautaAndAffiliated(Pauta pauta, Affiliated affiliated);

	@Query(value = "SELECT COUNT(id) as total, vote  FROM vote  WHERE  pauta_id = :idPauta  group by vote ", nativeQuery = true)
	List<VoteTotalInterface> countTotalVoteByIdPauta(@Param("idPauta") Integer idPauta);

	public interface VoteTotalInterface {

		String getVote();

		int getTotal();

	}
}
