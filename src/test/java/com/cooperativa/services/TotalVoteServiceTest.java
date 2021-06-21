package com.cooperativa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cooperativa.api.reponsesdtos.VoteTotalResponseDTO;
import com.cooperativa.domain.repositories.VoteRepository;
import com.cooperativa.domain.repositories.VoteRepository.VoteTotalInterface;
import com.cooperativa.services.domain.TotalVoteService;
import com.cooperativa.services.domain.impl.TotalVoteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TotalVoteServiceTest {
	
	private static 	final String VOTESIM = "SIM";
	private static 	final String VOTENAO = "NAO";

	@Mock
	private VoteRepository voteRepository;

	@InjectMocks
	private TotalVoteService service = new TotalVoteServiceImpl();

	@Test
	@DisplayName("should be able return total votes")
	void TestGetTotalVote() {
		List<VoteTotalInterface> voteList = new ArrayList<>();
		voteList.add(getMockTotalVote(VOTESIM, 2));
		voteList.add(getMockTotalVote(VOTENAO, 2));

		when(voteRepository.countTotalVoteByIdPauta(Mockito.anyInt())).thenReturn(voteList);

		Iterable<VoteTotalResponseDTO> response = service.calculateVote(1);

		VoteTotalResponseDTO voteDTOSIM = convertListeReponseInteralbeToDTO(response, "SIM");
		VoteTotalResponseDTO voteDTONAO = convertListeReponseInteralbeToDTO(response, "NAO");
		
		assertNotNull(StreamSupport.stream(response.spliterator(), false));
		assertEquals("SIM", voteDTOSIM.getVote());
		assertEquals(2, voteDTOSIM.getTotal());
		assertEquals("NAO", voteDTONAO.getVote());
		assertEquals(2, voteDTONAO.getTotal());

	}

	
	@Test
	@DisplayName("should be able return total votes sim > 0 and total vote nao 0")
	void TestGetTotalVoteSim() {
		List<VoteTotalInterface> voteList = new ArrayList<>();
		voteList.add(getMockTotalVote(VOTESIM, 2));

		when(voteRepository.countTotalVoteByIdPauta(Mockito.anyInt())).thenReturn(voteList);

		Iterable<VoteTotalResponseDTO> response = service.calculateVote(1);

		VoteTotalResponseDTO voteDTOSIM = convertListeReponseInteralbeToDTO(response, "SIM");
		VoteTotalResponseDTO voteDTONAO = convertListeReponseInteralbeToDTO(response, "NAO");
		
		assertNotNull(StreamSupport.stream(response.spliterator(), false));
		assertEquals("SIM", voteDTOSIM.getVote());
		assertEquals(2, voteDTOSIM.getTotal());
		assertEquals("NAO", voteDTONAO.getVote());
		assertEquals(0, voteDTONAO.getTotal());

	}
	
	@Test
	@DisplayName("should be able return total votes sim 0 and total vote nao > 0")
	void TestGetTotalVoteNao() {
		List<VoteTotalInterface> voteList = new ArrayList<>();
		voteList.add(getMockTotalVote(VOTENAO, 2));

		when(voteRepository.countTotalVoteByIdPauta(Mockito.anyInt())).thenReturn(voteList);

		Iterable<VoteTotalResponseDTO> response = service.calculateVote(1);

		VoteTotalResponseDTO voteDTOSIM = convertListeReponseInteralbeToDTO(response, "SIM");
		VoteTotalResponseDTO voteDTONAO = convertListeReponseInteralbeToDTO(response, "NAO");
		
		assertNotNull(StreamSupport.stream(response.spliterator(), false));
		assertEquals("SIM", voteDTOSIM.getVote());
		assertEquals(0, voteDTOSIM.getTotal());
		assertEquals("NAO", voteDTONAO.getVote());
		assertEquals(2, voteDTONAO.getTotal());

	}
	@Test
	@DisplayName("should be able return total votes list Empty")
	void TestGetTotalVoteListEmpty() {
		List<VoteTotalInterface> voteList = new ArrayList<>();
		voteList.addAll(new ArrayList<VoteTotalInterface>());

		when(voteRepository.countTotalVoteByIdPauta(Mockito.anyInt())).thenReturn(voteList);

		Iterable<VoteTotalResponseDTO> response = service.calculateVote(1);

		VoteTotalResponseDTO voteDTOSIM = convertListeReponseInteralbeToDTO(response, "SIM");
		VoteTotalResponseDTO voteDTONAO = convertListeReponseInteralbeToDTO(response, "NAO");
		
		assertNotNull(StreamSupport.stream(response.spliterator(), false));
		assertEquals("SIM", voteDTOSIM.getVote());
		assertEquals(0, voteDTOSIM.getTotal());
		assertEquals("NAO", voteDTONAO.getVote());
		assertEquals(0, voteDTONAO.getTotal());

	}
	private VoteTotalInterface getMockTotalVote(String vote, int total) {
		VoteTotalInterface v = new VoteTotalInterface() {

			@Override
			public String getVote() {
				return vote;
			}

			@Override
			public int getTotal() {
				return total;
			}
		};
		return v;
	}

	

	private VoteTotalResponseDTO convertListeReponseInteralbeToDTO(Iterable<VoteTotalResponseDTO> response, String vote) {
		return StreamSupport.stream(response.spliterator(), false).filter(v -> v.getVote().equals(vote))
				.findAny().get();

	}
}
