package com.cooperativa.services.client;

import org.springframework.stereotype.Service;

@Service
public interface ValidateCPFService {
	int validateCPF(String cpf);	
}
