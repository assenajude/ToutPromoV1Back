package com.ToutPromoV1.entities;

public class likeVoteCount {
	
	private Long idProd;
	private Long likeVoteCount;
	
	public likeVoteCount(Long idProd, Long likeVoteCount) {
		this.idProd = idProd;
		this.likeVoteCount = likeVoteCount;
	}

	public Long getIdProd() {
		return idProd;
	}

	public Long getLikeVoteCount() {
		return likeVoteCount;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public void setLikeVoteCount(Long likeVoteCount) {
		this.likeVoteCount = likeVoteCount;
	}
	
	

}
