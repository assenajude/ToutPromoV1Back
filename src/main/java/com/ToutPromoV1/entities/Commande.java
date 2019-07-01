package com.ToutPromoV1.entities;



import java.util.Collection;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.ToutPromoV1.entities.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
  

@Entity
@Table(name="commandes")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="paniers")
public class Commande extends UserDateAudit {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCmde;
	private String statutPayement;
	private String statusLivraison;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateCreated;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_client", nullable=false)
	private Client client; 
	@OneToMany(mappedBy="commande")
	private Collection<Livraison>livraisons;
	
	@OneToMany(mappedBy="commande")
	private Collection<Payement>payements;
/*	
	@JsonManagedReference
	@OneToMany(mappedBy="lc.commande")
	@Valid*/
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande>ligneCommandes;
	
/*	@Transient
	public Double getTotalCmdePrice() {
		double sumTot=0D;
		List<Panier>LignePaniers = getPaniers();
		for(Panier p:paniers) {
			sumTot +=p.getTotalPrice();
		}
		return sumTot;
	}

	@Transient
	public int getNombreProduit() {
		return this.paniers.size();
	}*/

	public Long getIdCmde() {
		return idCmde;
	}

	public String getStatutPayement() {
		return statutPayement;
	}

	public String getStatusLivraison() {
		return statusLivraison;
	}

	public Client getClient() {
		return client;
	}

	public Collection<Livraison> getLivraisons() {
		return livraisons;
	}

	public Collection<Payement> getPayements() {
		return payements;
	}
	
/*
	public List<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}*/
	

	public Collection<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public void setIdCmde(Long idCmde) {
		this.idCmde = idCmde;
	}

	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public void setStatutPayement(String statutPayement) {
		this.statutPayement = statutPayement;
	}

	public void setStatusLivraison(String statusLivraison) {
		this.statusLivraison = statusLivraison;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setLivraisons(Collection<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public void setPayements(Collection<Payement> payements) {
		this.payements = payements;
	}

	
	public Commande(String statutPayement, String statusLivraison, Date dateCreated, Client client,
			Collection<Payement> payements) {
		this.statutPayement = statutPayement;
		this.statusLivraison = statusLivraison;
		this.dateCreated = dateCreated;
		this.client = client;
		this.payements = payements;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
