package com.cooperativa.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooperativa.domain.models.Pauta;

@Repository
public interface PautaRepository extends CrudRepository<Pauta, Integer>{

}
