package com.cooperativa.services.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
    Logger logger = LoggerFactory.getLogger(AffiliatedServiceImpl.class);
	
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
			logger.error("Cpf inválido!");
			throw new BusinessRuleException("Cpf invalido");
			
		} 
	    
		if(statusCode == 500) {
			logger.error("Erro acesso a api!");
			throw new BusinessRuleException("Ocorreu um erro ao validar o cpf!");
		}
		Affiliated affiliatedResult = repository.save(affiliated);
		logger.info("Afiliado cadastrado!");
		return affiliatedResult;
	}
	/**
     * Método responsável por listas affiliateds .
     * 
     * @author Marcos Ribeiro
     * @param  void 
     * @return Iterable<Objeto> - Affiliated.
     */
	@Override
	public Iterable<Affiliated> getAll() {
		Iterable<Affiliated> listaAffliated = repository.findAll();
		logger.info("Lista de afiliados: {}", listaAffliated);
		return listaAffliated;
	}

}
