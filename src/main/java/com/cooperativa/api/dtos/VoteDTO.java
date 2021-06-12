package com.cooperativa.api.dtos;

public class VoteDTO {
	
	private Integer pautaId;
	private Integer affiliatedId;
	private String vote;

	public VoteDTO(Integer pautaId, Integer affiliatedId, String vote) {
		this.pautaId = pautaId;
		this.affiliatedId = affiliatedId;
		this.vote = vote;
	}
	
	public Integer getPautaId() {
		return pautaId;
	}
	public void setPautaId(Integer pautaId) {
		this.pautaId = pautaId;
	}
	public Integer getAffiliatedId() {
		return affiliatedId;
	}
	public void setAffiliatedId(Integer affiliatedId) {
		this.affiliatedId = affiliatedId;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	
	
}
