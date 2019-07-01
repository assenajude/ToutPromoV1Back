package com.ToutPromoV1.payloads.response;

import java.time.Instant;
import java.util.List;

public class CommandeResponse {
	
	private Long id;
	private List<LignePanierResponse>ligneCommandes;
	private UserSummary createdBy;
	private Instant creationDateTime;
	private Long totalProduits;
	private Double montantCmde;
	public CommandeResponse(Long id, List<LignePanierResponse> ligneCommandes, UserSummary createdBy,
			Instant creationDateTime, Long totalProduits, Double montantCmde) {
		this.id = id;
		this.ligneCommandes = ligneCommandes;
		this.createdBy = createdBy;
		this.creationDateTime = creationDateTime;
		this.totalProduits = totalProduits;
		this.montantCmde = montantCmde;
	}
	public Long getId() {
		return id;
	}
	public List<LignePanierResponse> getLigneCommandes() {
		return ligneCommandes;
	}
	public UserSummary getCreatedBy() {
		return createdBy;
	}
	public Instant getCreationDateTime() {
		return creationDateTime;
	}
	public Long getTotalProduits() {
		return totalProduits;
	}
	public Double getMontantCmde() {
		return montantCmde;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLigneCommandes(List<LignePanierResponse> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	public void setCreatedBy(UserSummary createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreationDateTime(Instant creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public void setTotalProduits(Long totalProduits) {
		this.totalProduits = totalProduits;
	}
	public void setMontantCmde(Double montantCmde) {
		this.montantCmde = montantCmde;
	}
	
	
	
	

}
