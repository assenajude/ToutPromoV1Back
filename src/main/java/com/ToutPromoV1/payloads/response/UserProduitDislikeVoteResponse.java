package com.ToutPromoV1.payloads.response;

import com.ToutPromoV1.entities.Produit;

public class UserProduitDislikeVoteResponse {
	
	private String username;
	private String name;
	private Produit produit;
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public UserProduitDislikeVoteResponse(String username, String name, Produit produit) {
		this.username = username;
		this.name = name;
		this.produit = produit;
	}
	
	

}
