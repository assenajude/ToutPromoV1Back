package com.ToutPromoV1.payloads.response;

public class ProduitFileInfos {
	private String fileName;
	private String fileUrl;
	
	
	public ProduitFileInfos(String fileName, String fileUrl) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}


	public String getFileName() {
		return fileName;
	}


	public String getFileUrl() {
		return fileUrl;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	

}
