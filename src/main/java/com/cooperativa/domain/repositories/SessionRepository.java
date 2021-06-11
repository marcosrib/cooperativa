package com.cooperativa.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooperativa.domain.models.Session;
@Repository
public interface SessionRepository extends CrudRepository<Session, Integer>{

}