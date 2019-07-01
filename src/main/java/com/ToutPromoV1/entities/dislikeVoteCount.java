package com.ToutPromoV1.entities;

public class dislikeVoteCount {
	
	private Long idProd;
	private Long dislikeVoteCount;
	
	
	public dislikeVoteCount(Long idProd, Long dislikeVoteCount) {
		this.idProd = idProd;
		this.dislikeVoteCount = dislikeVoteCount;
	}


	public Long getIdProd() {
		return idProd;
	}


	public Long getDislikeVoteCount() {
		return dislikeVoteCount;
	}


	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}


	public void setDislikeVoteCount(Long dislikeVoteCount) {
		this.dislikeVoteCount = dislikeVoteCount;
	}
	
	

}
