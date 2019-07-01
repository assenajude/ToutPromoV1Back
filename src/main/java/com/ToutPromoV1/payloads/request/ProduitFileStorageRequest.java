package com.ToutPromoV1.payloads.request;


public class ProduitFileStorageRequest {
	
	private String designProd;
	private String descripProd;
	private double prixProd;
	private int qteStockProd;
	private byte[] image;
	private String lienImage;
	private String nomImage;
	private String typeImage;
	private long tailleImage;
	
	public ProduitFileStorageRequest(String designProd, String descripProd, double prixProd, int qteStockProd, byte[] image,
			String nomImage, String typeImage, long tailleImage) {
		this.designProd = designProd;
		this.descripProd = descripProd;
		this.prixProd = prixProd;
		this.qteStockProd = qteStockProd;
		this.image = image;
		this.nomImage = nomImage;
		this.typeImage = typeImage;
		this.tailleImage = tailleImage;
	}


	public ProduitFileStorageRequest(String designProd, String descripProd, double prixProd, int qteStockProd,
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

	public byte[] getImage() {
		return image;
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

	public void setImage(byte[] image) {
		this.image = image;
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

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}
	
	

}
