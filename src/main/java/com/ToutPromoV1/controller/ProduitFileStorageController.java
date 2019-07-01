package com.ToutPromoV1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.payloads.response.ProduitFileInfos;
import com.ToutPromoV1.payloads.response.ProduitStorageResponse;
import com.ToutPromoV1.repositories.ProduitRepository;
import com.ToutPromoV1.services.ProduitFileStorageService;
import com.ToutPromoV1.services.ProduitService;

@RestController
@RequestMapping("/api/files")
public class ProduitFileStorageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduitFileStorageController.class);
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	private ProduitFileStorageService produitFileStorageService;
	
	private List<String>files=new ArrayList<String>();
	
	@PostMapping("/upload")
	public Produit addProduit(Produit p,@RequestParam("file")MultipartFile file) {
		Produit pp =null;
		String fileName="";
		String lienImage="";
		try {
			pp=produitService.saveProduit(p);
			fileName=produitFileStorageService.saveFileProduit(file,pp);
		    lienImage=MvcUriComponentsBuilder.fromMethodName(ProduitFileStorageController.class, "downloadFile", fileName.toString()).build().toString();
		    
		    pp.setNomImage(fileName);
		    pp.setLienImage(lienImage);
		  
			files.add(file.getOriginalFilename());
			
			produitService.saveProduit(pp);
		}catch(Exception e) {
			e.printStackTrace();
			updateProduit(p.getIdProd(), p);
		}
		return pp;
	}

	@PutMapping
	public Produit updateProduit(@PathVariable Long id,@RequestBody Produit p) {
		p.setIdProd(id);
		return produitService.saveProduit(p);
	}
	


	/*
	
	@PostMapping("/uploadMultipleFiles")
	public List<ProduitStorageResponse>uploadMultipleFiles(@RequestParam("files")MultipartFile files){
		return Arrays.asList(files)
				.stream()
				.map(file->uploadFile(file))
				.collect(Collectors.toList());
		
	}*/
	
	
	@GetMapping("/downloadFile/{fileName:.+}")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable("fileName")String fileName){
		Resource file = produitFileStorageService.getFile(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	@GetMapping("listProduitFiles")
	public List<ProduitFileInfos> getListProduitFiles() {
		List<ProduitFileInfos> fileInfos=produitFileStorageService.getAllFiles().map(
				path->{
					String fileName=path.getFileName().toString();
					String fileUrl=MvcUriComponentsBuilder.fromMethodName(ProduitFileStorageController.class, "downloadFile", path.getFileName().toString()).build().toString();
					return new ProduitFileInfos(fileName, fileUrl);
				}
				).collect(Collectors.toList());
		//model.addAttribute(fileInfos);
		return fileInfos;
	}
	
	@DeleteMapping
	public boolean delAllFiles() {
		produitFileStorageService.deleteAll();
		
		return true;
	}
	
	
}
