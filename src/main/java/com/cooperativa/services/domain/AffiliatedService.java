package com.cooperativa.services.domain;

import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Affiliated;

@Service
public interface AffiliatedService {
	Affiliated create(Affiliated affiliated);
	Iterable<Affiliated> getAll();
}
