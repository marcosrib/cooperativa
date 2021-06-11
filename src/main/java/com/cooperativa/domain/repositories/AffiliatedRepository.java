package com.cooperativa.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooperativa.domain.models.Affiliated;

@Repository
public interface AffiliatedRepository extends CrudRepository<Affiliated, Long>{

}
