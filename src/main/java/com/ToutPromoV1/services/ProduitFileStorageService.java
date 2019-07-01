package com.ToutPromoV1.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.exception.FileNotFoundException;
import com.ToutPromoV1.exception.FileStorageException;
import com.ToutPromoV1.properties.FileStorageProperties;

@Service
public class ProduitFileStorageService {
	private String imageCDN = "http://localhost:8082/uploads/";
	

	private final Path produitFileStorageLocation;
	
	@Autowired
	public ProduitFileStorageService(FileStorageProperties fileStorageProperties) {
		this.produitFileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
				.toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.produitFileStorageLocation);
		}catch(Exception ex) {
			throw new FileStorageException("Impossible de creer le repertoire de stockage", ex);
		}
	}
	/*
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new FileStorageException("Desole, le nom du fichier contient des carateres non autorises"+fileName);
			}
			Path targetLocation = this.produitFileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		}catch (IOException ex) {
			throw new FileStorageException("Impossible de stocker le fichier"+fileName+"Veillez reessayer svp",ex);
			
		}
	}*/
	
	public String saveFileProduit(MultipartFile file, Produit p) {
		String storedLocation=null;
		
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		//fileName=p.getIdProd()+"."+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
		
		try {
			if(file.isEmpty()) {
				throw new FileStorageException("Echec!Le fichier est vide"+"Fichier"+filename);
			}
			if(filename.contains("..")) {
				throw new FileStorageException("Aucun fichier"+filename+"trouve dans le repertoire indique");
			}
			Path targetLocation = this.produitFileStorageLocation.resolve(filename);
			Files.copy(file.getInputStream(), targetLocation,StandardCopyOption.REPLACE_EXISTING);
			storedLocation = this.produitFileStorageLocation+filename;
			
		}catch(IOException ex) {
			throw new FileStorageException("Enregistrement de produit"+ filename+"echoue", ex);
		}
		
		p.setLienImage(this.produitFileStorageLocation+filename);
		return filename;
	}
	
	
	public Resource getFile(String fileName) {
		try {
			Path filePath = this.produitFileStorageLocation.resolve(fileName).normalize();
			Resource resource = 	new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}else {
				throw new FileNotFoundException("Fichier introuvable"+fileName);
			}
		}catch(MalformedURLException ex) {
			throw new FileNotFoundException("Fichier introuvable"+fileName, ex);
		}
		
	}

	public Stream<Path>getAllFiles(){
		
		try {
		return Files.walk(this.produitFileStorageLocation, 1)
				.filter(path->!path.equals(produitFileStorageLocation))
				.map(this.produitFileStorageLocation::relativize);
		}catch(IOException ex) {
			throw new FileStorageException("Impossible de lire les fichiers");
		}
		
	}
	  public void deleteAll() {
	        FileSystemUtils.deleteRecursively(this.produitFileStorageLocation.toFile());
	        
	    }
	
}
