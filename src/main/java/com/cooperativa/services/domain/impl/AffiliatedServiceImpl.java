package com.cooperativa.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.repositories.AffiliatedRepository;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.services.client.ValidateCPFService;
import com.cooperativa.services.domain.AffiliatedService;
/**
 * Service responsável por implementar a regra de negócio do afiliados
 * 
 * @author Marcos Ribeiro
 */
@Service
public class AffiliatedServiceImpl implements AffiliatedService{
    @Autowired
	private AffiliatedRepository repository;
    
    @Autowired
    private ValidateCPFService validateCPFService;
    /**
     * Método responsável por criar um afiliado.
     * 
     * @author Marcos Ribeiro
     * @param Objeto - Affiliated 
     * @return Objeto - Affiliated.
     */
	@Override
	public Affiliated create(Affiliated affiliated) {
		int statusCode = validateCPFService.validateCPF(affiliated.getCpf());
		if (statusCode == 404) {
			throw new BusinessRuleException("Cpf invalido");
		} 
	    
		if(statusCode == 500) {
			throw new BusinessRuleException("Ocorreu um erro ao validar o cpf!");
		}
		return repository.save(affiliated);
	}

}
