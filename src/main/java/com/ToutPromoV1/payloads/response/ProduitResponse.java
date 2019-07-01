package com.ToutPromoV1.payloads.response;

import com.ToutPromoV1.entities.Espace;
import com.ToutPromoV1.payloads.request.ProduitTimeLength;

import java.time.Instant;

public class ProduitResponse {
	private Long idProd;
	private String designProd;
	private String descripProd;
	private double prixProd;
	private double prixminProd;
	private double prixmaxProd;
	private int qteStockProd;
	private String infosMarque;
	private int totalVotant;
	private int currentVotant=0;
	private double percent=0;
	private boolean goSpin=false;
	private boolean panelCollapsed=true;
	private String nomImage;
	private String lienImage;
	private Espace espace;
	private Instant ExpirationDateTime;
	private Boolean isExpired;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public String getDesignProd() {
		return designProd;
	}

	public void setDesignProd(String designProd) {
		this.designProd = designProd;
	}

	public String getDescripProd() {
		return descripProd;
	}

	public void setDescripProd(String descripProd) {
		this.descripProd = descripProd;
	}

	public double getPrixProd() {
		return prixProd;
	}

	public void setPrixProd(double prixProd) {
		this.prixProd = prixProd;
	}

	public double getPrixminProd() {
		return prixminProd;
	}

	public void setPrixminProd(double prixminProd) {
		this.prixminProd = prixminProd;
	}

	public double getPrixmaxProd() {
		return prixmaxProd;
	}

	public void setPrixmaxProd(double prixmaxProd) {
		this.prixmaxProd = prixmaxProd;
	}

	public int getQteStockProd() {
		return qteStockProd;
	}

	public void setQteStockProd(int qteStockProd) {
		this.qteStockProd = qteStockProd;
	}

	public String getInfosMarque() {
		return infosMarque;
	}

	public void setInfosMarque(String infosMarque) {
		this.infosMarque = infosMarque;
	}

	public int getTotalVotant() {
		return totalVotant;
	}

	public void setTotalVotant(int totalVotant) {
		this.totalVotant = totalVotant;
	}

	public int getCurrentVotant() {
		return currentVotant;
	}

	public void setCurrentVotant(int currentVotant) {
		this.currentVotant = currentVotant;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public boolean isGoSpin() {
		return goSpin;
	}

	public void setGoSpin(boolean goSpin) {
		this.goSpin = goSpin;
	}

	public boolean isPanelCollapsed() {
		return panelCollapsed;
	}

	public void setPanelCollapsed(boolean panelCollapsed) {
		this.panelCollapsed = panelCollapsed;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	public Instant getExpirationDateTime() {
		return ExpirationDateTime;
	}

	public void setExpirationDateTime(Instant expirationDateTime) {
		ExpirationDateTime = expirationDateTime;
	}

	public Boolean getExpired() {
		return isExpired;
	}

	public void setExpired(Boolean expired) {
		isExpired = expired;
	}
}
