package com.cooperativa.api.dtos;

import io.swagger.annotations.ApiModelProperty;

public class VoteDTO {
	@ApiModelProperty(value = "Id pauta", required = true)
	private Integer pautaId;
	@ApiModelProperty(value = "Id  affiliado", required = true)
	private Integer affiliatedId;
	@ApiModelProperty(value = "Voto: SIM OU NAO", required = true)
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
