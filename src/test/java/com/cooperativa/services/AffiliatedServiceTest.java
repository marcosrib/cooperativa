package com.cooperativa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cooperativa.domain.models.Affiliated;
import com.cooperativa.domain.repositories.AffiliatedRepository;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.services.client.ValidateCPFService;
import com.cooperativa.services.domain.AffiliatedService;
import com.cooperativa.services.domain.impl.AffiliatedServiceImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatedServiceTest {

	@Mock
	private AffiliatedRepository repository;

	@Mock
	private ValidateCPFService vServie;

	@InjectMocks
	private AffiliatedService service = new AffiliatedServiceImpl();

	@Test
	@DisplayName("should be able create afiliated")
	void TestCreate() {
		when(repository.save(any(Affiliated.class))).thenReturn(getDados());
		when(vServie.validateCPF(getDados().getCpf())).thenReturn(200);

		Affiliated afilliated = service.create(getDados());
		assertNotNull(afilliated);
		assertEquals(getDados().getCpf(), afilliated.getCpf());

	}

	@Test
	@DisplayName("should be able return cpf invalid excpetion")
	void TestValidateCpf() {
		lenient().when(vServie.validateCPF(getDados().getCpf())).thenReturn(404);
		assertThrows(BusinessRuleException.class, () -> service.create(getDados()), "Cpf inválido!");
	}
	
	@Test
	@DisplayName("should be able return erro servidor 500 excpetion")
	void TestValidateCpfErrorServidor() {
		lenient().when(vServie.validateCPF(getDados().getCpf())).thenReturn(500);
		assertThrows(BusinessRuleException.class, () -> service.create(getDados()), "Ocorreu um erro ao validar o cpf!");
	}
	
	@Test
	@DisplayName("should be able return list affiliated")
	void TestGetAll() {
		List<Affiliated> affiliatedList = new ArrayList<>();
		affiliatedList.add(getDados());
		Iterable<Affiliated> affiliateds =affiliatedList;
		when(repository.findAll()).thenReturn(affiliateds);

		Iterable<Affiliated> response = service.getAll();

		assertNotNull(StreamSupport.stream(response.spliterator(), false));
	  }

	private Affiliated getDados() {
		Affiliated a = new Affiliated();
		a.setId(1);
		a.setCpf("00795929374");
		a.setName("marcos");
		return a;
	}
}
