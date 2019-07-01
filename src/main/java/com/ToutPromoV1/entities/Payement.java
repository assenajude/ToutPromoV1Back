package com.ToutPromoV1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ToutPromoV1.entities.audit.DateAudit;

@Entity
public class Payement extends DateAudit {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaye;
	private Double montantPaye;
	private int qtePaye;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_cmde", nullable=false)
	private Commande commande;
	public Long getIdPaye() {
		return idPaye;
	}
	public Double getMontantPaye() {
		return montantPaye;
	}
	public int getQtePaye() {
		return qtePaye;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setIdPaye(Long idPaye) {
		this.idPaye = idPaye;
	}
	public void setMontantPaye(Double montantPaye) {
		this.montantPaye = montantPaye;
	}
	public void setQtePaye(int qtePaye) {
		this.qtePaye = qtePaye;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Payement() {
		// TODO Auto-generated constructor stub
	}
	public Payement(Double montantPaye, int qtePaye, Commande commande) {
		this.montantPaye = montantPaye;
		this.qtePaye = qtePaye;
		this.commande = commande;
	}
	
	

}
