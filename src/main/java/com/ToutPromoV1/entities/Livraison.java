package com.ToutPromoV1.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ToutPromoV1.entities.audit.DateAudit;

@Entity
public class Livraison extends DateAudit {
	
	@Id @GeneratedValue
	private Long idLivr;
	private Double montantLivr;
	private int qteLivr;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_cmde", nullable=false)
	private Commande commande;

	public Long getIdLivr() {
		return idLivr;
	}

	public Double getMontantLivr() {
		return montantLivr;
	}

	public int getQteLivr() {
		return qteLivr;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setIdLivr(Long idLivr) {
		this.idLivr = idLivr;
	}

	public void setMontantLivr(Double montantLivr) {
		this.montantLivr = montantLivr;
	}

	public void setQteLivr(int qteLivr) {
		this.qteLivr = qteLivr;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Livraison() {
		// TODO Auto-generated constructor stub
	}

	public Livraison(Double montantLivr, int qteLivr, Commande commande) {
		this.montantLivr = montantLivr;
		this.qteLivr = qteLivr;
		this.commande = commande;
	}
	
	
	

}
