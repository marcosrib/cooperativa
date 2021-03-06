package com.cooperativa.services.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cooperativa.services.client.ValidateCPFService;
/**
 * Service responsável por conetar na api externa de validaçaõ de cpf 
 * 
 * @author Marcos Ribeiro
 */
@Service
public class ValidateCPFServiceImpl implements ValidateCPFService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${path.url-validete-cpf}")
	private String url;


    /**
     * Método responsável pela validação do cpf
     * 
     * @author Marcos Ribeiro
     * @param String - cpf 
     * @return int - código do erro.
     */
	@Override
	public int validateCPF(String cpf) {
		String urlWithParam = url + cpf;
		HttpStatus statusCode = null;
		try {
			ResponseEntity<Object> response = restTemplate.getForEntity(urlWithParam, Object.class);
			statusCode = response.getStatusCode();
		} catch (HttpStatusCodeException e) {
			statusCode = e.getStatusCode();
		}
		return statusCode.value();
	}

}
