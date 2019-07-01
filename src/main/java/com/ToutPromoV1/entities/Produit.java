package com.ToutPromoV1.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="produits")
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idProd; 
	private String designProd;
	private String descripProd;
	private double prixProd;
	private double prixminProd;
	private double prixmaxProd;
	private int qteStockProd;
	private String infosMarque;
	private Instant expirationDate;
	private int totalVotant;
    private int currentVotant=0;
    private double percent=0;
    private boolean goSpin=false;
    private boolean panelCollapsed=true;
	private String nomImage;
	private String lienImage;
	
	@OneToMany(mappedBy="produit")
    private Collection<LikeVote>likeVotes;
	@OneToMany(mappedBy="produit")
	private Collection<DislikeVote>dislikeVotes;
	
	@ManyToOne
	@JoinColumn(name="espace_id")
    private Espace espace;
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Produit(Long idProd,Instant expirationDate, String designProd,int currentVotant, double percent, String descripProd, double prixProd,double prixminProd,double prixmaxProd, int qteStockProd,
			String infosMarque,boolean goSpin, boolean panelCollapsed, String nomImage, String lienImage, Collection<LikeVote> likeVotes, Collection<DislikeVote> dislikeVotes, Espace espace,
				   int totalVotant) {
		this.idProd = idProd;
		this.designProd = designProd;
		this.descripProd = descripProd;
		this.prixProd = prixProd;
		this.prixminProd = prixminProd;
		this.prixmaxProd = prixmaxProd;
		this.qteStockProd = qteStockProd;
		this.infosMarque = infosMarque;
		this.expirationDate = expirationDate;
		this.nomImage = nomImage;
		this.lienImage = lienImage;
		this.likeVotes = likeVotes;
		this.dislikeVotes = dislikeVotes;
		this.espace = espace;
		this.totalVotant=totalVotant;
		this.currentVotant=currentVotant;
		this.percent=percent;
		this.goSpin=goSpin;
		this.panelCollapsed=panelCollapsed;

	}

	public boolean isPanelCollapsed() {
		return panelCollapsed;
	}

	public void setPanelCollapsed(boolean panelCollapsed) {
		this.panelCollapsed = panelCollapsed;
	}

	public boolean isGoSpin() {
        return goSpin;
    }

    public void setGoSpin(boolean goSpin) {
        this.goSpin = goSpin;
    }

    public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getCurrentVotant() {
		return currentVotant;
	}

	public void setCurrentVotant(int currentVotant) {
		this.currentVotant = currentVotant;
	}

	public int getTotalVotant() {
		return totalVotant;
	}

	public void setTotalVotant(int totalVotant) {
		this.totalVotant = totalVotant;
	}

	public Long getIdProd() {
		return idProd;
	}


	public String getDesignProd() {
		return designProd;
	}


	public String getDescripProd() {
		return descripProd;
	}


	public Instant getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Instant expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getInfosMarque() {
		return infosMarque;
	}



@JsonIgnore
	public Espace getEspace() {
		return espace;
	}


	public void setInfosMarque(String infosMarque) {
		this.infosMarque = infosMarque;
	}




	public Collection<LikeVote> getLikeVotes() {
		return likeVotes;
	}


	public Collection<DislikeVote> getDislikeVotes() {
		return dislikeVotes;
	}


	public void setLikeVotes(Collection<LikeVote> likeVotes) {
		this.likeVotes = likeVotes;
	}


	public void setDislikeVotes(Collection<DislikeVote> dislikeVotes) {
		this.dislikeVotes = dislikeVotes;
	}

@JsonSetter
	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	public String getNomImage() {
		return nomImage;
	}




	public double getPrixProd() {
		return prixProd;
	}


	public double getPrixminProd() {
		return prixminProd;
	}


	public double getPrixmaxProd() {
		return prixmaxProd;
	}


	public void setPrixminProd(double prixminProd) {
		this.prixminProd = prixminProd;
	}


	public void setPrixmaxProd(double prixmaxProd) {
		this.prixmaxProd = prixmaxProd;
	}


	public int getQteStockProd() {
		return qteStockProd;
	}


	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}


	public void setDesignProd(String designProd) {
		this.designProd = designProd;
	}


	public void setDescripProd(String descripProd) {
		this.descripProd = descripProd;
	}



	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}



	public void setPrixProd(double prixProd) {
		this.prixProd = prixProd;
	}


	public void setQteStockProd(int qteStockProd) {
		this.qteStockProd = qteStockProd;
	}


	public String getLienImage() {
		return lienImage;
	}


	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}



	
	

}
