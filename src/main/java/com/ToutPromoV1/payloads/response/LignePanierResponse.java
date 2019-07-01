package com.ToutPromoV1.payloads.response;

import javax.persistence.Transient;

import com.ToutPromoV1.entities.Produit;

public class LignePanierResponse {
	
	private Produit produit;
	private int qteCmde;
	private Double prixUnitaire;
	private Double sousTotal;
	
	public LignePanierResponse(Produit produit, int qteCmde, Double prixUnitaire, Double sousTotal) {
		this.produit = produit;
		this.qteCmde = qteCmde;
		this.prixUnitaire = prixUnitaire;
		this.sousTotal = sousTotal;
	}

	public Produit getProduit() {
		return produit;
	}

	public int getQteCmde() {
		return qteCmde;
	}


	public Double getPrixUnitaire() {
		return getProduit().getPrixProd();
	}

	public Double getSousTotal() {
		return getPrixUnitaire()*getQteCmde();
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setQteCmde(int qteCmde) {
		this.qteCmde = qteCmde;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public void setSousTotal(Double sousTotal) {
		this.sousTotal = sousTotal;
	}

	
}
