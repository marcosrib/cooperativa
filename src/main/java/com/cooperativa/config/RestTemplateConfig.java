package com.cooperativa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuração restTemplate.
 * 
 * @author Marcos Ribeiro
 */
@Configuration
public class RestTemplateConfig {
	/*
	 * Método responsável por injetar restTamplate.
	 * 
	 * @author Marcos Ribeiro
	 * 
	 * @param Objeto - VoteDTO
	 * 
	 * @return Objeto - Vote.
	 */
	@Bean
	public RestTemplate restTemplate() {
		var factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);

		return new RestTemplate(factory);

	}
}
