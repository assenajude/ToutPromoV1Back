package com.ToutPromoV1.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.ToutPromoV1.entities.audit.UserDateAudit;




//@Embeddable

@Entity
public class LigneCommande extends UserDateAudit{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLc;
	@ManyToOne
	@JoinColumn(name="idProd")
	private Produit produit;
	private int quantite;
	private double price;
	@ManyToOne
	@JoinColumn(name="idCmde")
	private Commande commande;
	public Long getIdLc() {
		return idLc;
	}
	public Produit getProduit() {
		return produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public double getPrice() {
		return price;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setIdLc(Long idLc) {
		this.idLc = idLc;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public LigneCommande(Produit produit, int quantite, double price) {
		this.produit = produit;
		this.quantite = quantite;
		this.price = price;
	}

	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Transient
	public Double sousTotal() {
		return getProduit().getPrixProd()*getQuantite();
	}

	
	
	
	
/*	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_cmde")
	private Commande commande;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_prod")
	private Produit produit;

	public Commande getCommande() {
		return commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
*/

	

	
	

}
