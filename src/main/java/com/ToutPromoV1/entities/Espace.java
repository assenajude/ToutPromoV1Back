package com.ToutPromoV1.entities;

import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name="espace")
public class Espace {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long espaceId;
	private String espaceName;
	private String espaceDescrip;
	@OneToMany(mappedBy="espace")
	private Collection<Produit>produits;
	public Long getEspaceId() {
		return espaceId;
	}
	public String getEspaceName() {
		return espaceName;
	}
	public String getEspaceDescrip() {
		return espaceDescrip;
	}
	@JsonGetter
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setEspaceId(Long espaceId) {
		this.espaceId = espaceId;
	}
	public void setEspaceName(String espaceName) {
		this.espaceName = espaceName;
	}
	public void setEspaceDescrip(String espaceDescrip) {
		this.espaceDescrip = espaceDescrip;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	public Espace() {
		// TODO Auto-generated constructor stub
	}
	public Espace(String espaceName, String espaceDescrip, Collection<Produit> produits) {
		this.espaceName = espaceName;
		this.espaceDescrip = espaceDescrip;
		this.produits = produits;
	}
	

}
