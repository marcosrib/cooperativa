package com.cooperativa.domain.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cooperativa.domain.enuns.VoteEnum;

/**
 * Classe entidade do tipo Vote responsável por armazenar os dados dos Votos.
 * 
 * @author Marcos Ribeiro
 */
@Entity
@Table(name = "vote")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private VoteEnum vote;
	
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;
	
	@ManyToOne
	@JoinColumn(name = "affiliated_id")
	private Affiliated affiliated;
	
	public Vote() {	}

	public Vote(VoteEnum vote, Pauta pauta, Affiliated affiliated) {
		this.vote = vote;
		this.pauta = pauta;
		this.affiliated = affiliated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public VoteEnum getVote() {
		return vote;
	}

	public void setVote(VoteEnum vote) {
		this.vote = vote;
	}

	public Affiliated getAffiliated() {
		return affiliated;
	}

	public void setAffiliated(Affiliated affiliated) {
		this.affiliated = affiliated;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", vote=" + vote +  "]";
	}

	
	
	
}
