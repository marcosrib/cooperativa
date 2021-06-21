package com.cooperativa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cooperativa.api.dtos.StartSessionDTO;
import com.cooperativa.domain.models.Pauta;
import com.cooperativa.domain.repositories.PautaRepository;
import com.cooperativa.exceptions.BusinessRuleException;
import com.cooperativa.services.domain.StartSessionService;
import com.cooperativa.services.domain.impl.StarteSessionServiceImpl;

@ExtendWith(MockitoExtension.class)
class StartSessionServiceTest {

	private static final LocalTime TIME = LocalTime.parse("00:01:00.342123342");

	@Mock
	private PautaRepository repository;

	@InjectMocks
	private StartSessionService service = new StarteSessionServiceImpl();

	@Test
	@DisplayName("should be able start session")
	void TestStartSession() {
		when(repository.findById(Mockito.anyInt())).thenReturn(getMockPauta(false));

		Pauta pauta = service.startSession(getMockStartSession("00:05:00"));
		assertNotNull(pauta);
		assertTrue(pauta.isSessionStarted());
		assertEquals(LocalTime.parse("00:05:00.342123342"), pauta.getTime());

	}

	@Test
	@DisplayName("should be able start session time zero")
	void TestStartSessionTimeZero() {
		when(repository.findById(Mockito.anyInt())).thenReturn(getMockPauta(false));

		Pauta pauta = service.startSession(getMockStartSession("00:00:00"));
		assertNotNull(pauta);
		assertTrue(pauta.isSessionStarted());
		assertEquals(TIME, pauta.getTime());

	}

	@Test
	@DisplayName("should be able start session time null")
	void TestStartSessionTimeNull() {
		when(repository.findById(Mockito.anyInt())).thenReturn(getMockPauta(false));

		Pauta pauta = service.startSession(getMockStartSession(null));
		assertNotNull(pauta);
		assertTrue(pauta.isSessionStarted());
		assertEquals(TIME, pauta.getTime());

	}

	@Test
	@DisplayName("should be able start session time empty")
	void TestStartSessionTimeEmpty() {
		when(repository.findById(Mockito.anyInt())).thenReturn(getMockPauta(false));

		Pauta pauta = service.startSession(getMockStartSession(""));
		assertNotNull(pauta);
		assertTrue(pauta.isSessionStarted());
		assertEquals(TIME, pauta.getTime());

	}

	@Test
	@DisplayName("should be able session started exception")
	void TestSessionStartedException() {
		lenient().when(repository.findById(Mockito.anyInt())).thenReturn(getMockPauta(true));
		assertThrows(BusinessRuleException.class, () -> service.startSession(getMockStartSession("")),
				"Session already initialized");
	}

	private Optional<Pauta> getMockPauta(boolean isSession) {
		Pauta pauta = new Pauta();
		pauta.setId(1);
		pauta.setName("Pauta 1");
		pauta.setSessionStarted(isSession);
		pauta.getTime();
		return Optional.of(pauta);
	}

	private StartSessionDTO getMockStartSession(String time) {
		StartSessionDTO session = new StartSessionDTO();
		session.setIdPauta(1);
		session.setTime(time);

		return session;
	}
}
