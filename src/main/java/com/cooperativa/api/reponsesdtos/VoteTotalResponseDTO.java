package com.cooperativa.api.reponsesdtos;

public class VoteTotalResponseDTO {
	private int total;
	private String vote;

	public VoteTotalResponseDTO(int total, String vote) {
		this.total = total;
		this.vote = vote;
	}

	public int getTotal() {
		return total;
	}

	public String getVote() {
		return vote;
	}
	
	

	@Override
	public String toString() {
		return "VoteTotalDTO [total=" + total + ", vote=" + vote + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + total;
		result = prime * result + ((vote == null) ? 0 : vote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteTotalResponseDTO other = (VoteTotalResponseDTO) obj;
		if (total != other.total)
			return false;
		if (vote == null) {
			if (other.vote != null)
				return false;
		} else if (!vote.equals(other.vote))
			return false;
		return true;
	}
	
	
}
