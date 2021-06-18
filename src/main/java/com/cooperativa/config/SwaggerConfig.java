package com.cooperativa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Classe de configuração swagger.
 * 
 * @author Marcos Ribeiro
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/*
	 * Método responsável por injetar as configurações da documentação da api versão 1.
	 * 
	 * @author Marcos Ribeiro
	 * 
	 * @param vazio
	 * 
	 * @return Objeto - Docket.
	 */
	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .groupName("api-version-1.0")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cooperativa.api.controllers"))
				.paths(PathSelectors.ant("/api/v1/**"))
				.build()
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfoV1());
	}
	/*
	 * Método responsável por injetar as configurações da documentação da api versão 2.
	 * 
	 * @author Marcos Ribeiro
	 * 
	 * @param vazio
	 * 
	 * @return Objeto - Docket.
	 */
	@Bean
	public Docket apiV2() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .groupName("api-version-2.0")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cooperativa.api.controllers"))
				.paths(PathSelectors.ant("/api/v2/**"))
				.build()
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfoV2());
	}
	
	/*
	 * Método responsável adicionar as informações principais da documentação da api versão 1.
	 * 
	 * @author Marcos Ribeiro
	 * 
	 * @param vazio
	 * 
	 * @return Objeto - ApiInfo.
	 */
	private ApiInfo apiInfoV1() {
	    return new ApiInfoBuilder()
	    		.version("2.0")
	            .title("API Cooperativa")
	            .description("Apicação que realiza cadastro e votação das pautas de uma cooperativa com Spring Boot REST API")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Marcos Ribeiro", "https://github.com/marcosrib", "teste@com.br"))
	            .build();
	}
	/*
	 * Método responsável adicionar as informações principais da documentação da api versão 2.
	 * 
	 * @author Marcos Ribeiro
	 * 
	 * @param vazio
	 * 
	 * @return Objeto - ApiInfo.
	 */
	private ApiInfo apiInfoV2() {
	    return new ApiInfoBuilder()
	    		.version("2.0")
	            .title("API Cooperativa")
	            .description("Apicação que realiza cadastro e votação das pautas de uma cooperativa com Spring Boot REST API")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Marcos Ribeiro", "https://github.com/marcosrib", "teste@com.br"))
	            .build();
	}
	 
}
