package com.cooperativa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.services.domain.PautaService;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PautaServiceTest {
	@MockBean
	private PautaRepository pautaRepository;

	@Autowired
	private PautaService service;

	@Test
	@DisplayName("should be able create pauta")
	void TesteCreate() {
		BDDMockito.given(pautaRepository.save(Mockito.any(Pauta.class))).willReturn(getMockPauta());

		Pauta response = service.create(new Pauta());

		assertNotNull(response);
		assertEquals(1, response.getId());
	}

	@Test
	@DisplayName("should be able return list pauta")
	void TestGetAll() {
		List<Pauta> pautaList = new ArrayList<>();
		pautaList.add(getMockPauta());
		Iterable<Pauta> pautas = pautaList;
		BDDMockito.given(pautaRepository.findAll()).willReturn(pautas);

		Iterable<Pauta> response = service.getAll();

		assertNotNull(StreamSupport.stream(response.spliterator(), false));

	}

	private Pauta getMockPauta() {
		Pauta pauta = new Pauta();
		pauta.setId(1);
		pauta.setName("Pauta 1");
		return pauta;
	}

}
