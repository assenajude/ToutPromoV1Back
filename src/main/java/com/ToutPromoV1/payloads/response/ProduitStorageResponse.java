package com.ToutPromoV1.payloads.response;

public class ProduitStorageResponse {
	
	private String designProd;
	private String descripProd;
	private double prixProd;
	private int qteStockProd;
	private String lienImage;
	private String nomImage;
	private String typeImage;
	private long tailleImage;
	
	
	public ProduitStorageResponse(String designProd, String descripProd, double prixProd, int qteStockProd,
			String lienImage, String nomImage, String typeImage, long tailleImage) {
		this.designProd = designProd;
		this.descripProd = descripProd;
		this.prixProd = prixProd;
		this.qteStockProd = qteStockProd;
		this.lienImage = lienImage;
		this.nomImage = nomImage;
		this.typeImage = typeImage;
		this.tailleImage = tailleImage;
	}


	public ProduitStorageResponse(String lienImage, String nomImage, String typeImage, long tailleImage) {
		this.lienImage = lienImage;
		this.nomImage = nomImage;
		this.typeImage = typeImage;
		this.tailleImage = tailleImage;
	}


	public String getDesignProd() {
		return designProd;
	}


	public String getDescripProd() {
		return descripProd;
	}


	public double getPrixProd() {
		return prixProd;
	}


	public int getQteStockProd() {
		return qteStockProd;
	}


	public String getLienImage() {
		return lienImage;
	}


	public String getNomImage() {
		return nomImage;
	}


	public String getTypeImage() {
		return typeImage;
	}


	public long getTailleImage() {
		return tailleImage;
	}


	public void setDesignProd(String designProd) {
		this.designProd = designProd;
	}


	public void setDescripProd(String descripProd) {
		this.descripProd = descripProd;
	}


	public void setPrixProd(double prixProd) {
		this.prixProd = prixProd;
	}


	public void setQteStockProd(int qteStockProd) {
		this.qteStockProd = qteStockProd;
	}


	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}


	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}


	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}


	public void setTailleImage(long tailleImage) {
		this.tailleImage = tailleImage;
	}
	
	
}
