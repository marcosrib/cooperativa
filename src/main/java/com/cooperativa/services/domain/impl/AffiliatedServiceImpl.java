package com.cooperativa.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.repositories.AffiliatedRepository;
import com.cooperativa.services.domain.AffiliatedService;

@Service
public class AffiliatedServiceImpl implements AffiliatedService{
    @Autowired
	private AffiliatedRepository repository;
	
	@Override
	public Affiliated create(Affiliated affiliated) {
		return repository.save(affiliated);
	}

}
