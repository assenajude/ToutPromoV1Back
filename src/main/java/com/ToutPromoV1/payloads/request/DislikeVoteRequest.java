package com.ToutPromoV1.payloads.request;

import javax.validation.constraints.NotNull;

public class DislikeVoteRequest {
	
	@NotNull
	private Long idProd;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}
	

}
