package com.ToutPromoV1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import com.ToutPromoV1.payloads.request.ProduitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.payloads.request.ProduitFileStorageRequest;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.services.ProduitService;
import com.ToutPromoV1.utils.AppConstants;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduitController.class);
	
	@Autowired
	private ProduitService produitService;
	
/*	@PostMapping
	 @PreAuthorize("hasRole('ADMIN')")
	public ProduitStorageRequest saveProduit(@RequestParam("file")MultipartFile file,@Valid @RequestBody Produit p) {
		Produit produit = produitService.storeProduit(file, p);
		
		String LienImage = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/newProduit/")
				.path(produit.getNomImage())
				.toString();
		return new ProduitStorageRequest(produit.getDesignProd(), produit.getDescripProd(), produit.getPrixProd(),produit.getQteStockProd(), LienImage, produit.getNomImage(), file.getContentType(), file.getSize());
	}*/
	
	@GetMapping
	public PagedResponse<Produit>afficheTousProduit(@RequestParam(value="page", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER) int page, @RequestParam(value="size", defaultValue=AppConstants.DEFAULT_PAGE_SIZE)int size){
		return produitService.getAllProduits(page, size);
	}

/*	@GetMapping("/espace/{idEsp}")
	public PagedResponse<Produit> getByEspace(@PathVariable("idEsp") Long idEsp,
											  @RequestParam(value="page", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER)int page,
											  @RequestParam(value="size", defaultValue=AppConstants.DEFAULT_PAGE_SIZE)int size){
		return produitService.getProduitsByEspace(idEsp, page, size);
	}*/
	@GetMapping("/espace/{id}")
	public Page<Produit> findProdByEspace(@PathVariable Long id, Pageable pageable){
		return produitService.getProduitEspace(id, pageable);
	}


	@PutMapping("/{id}")
	public Produit updateProduit(@PathVariable Long id, @Valid @RequestBody ProduitRequest p) {
		return produitService.modifProduit(p, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>supprimProduit(@PathVariable Long id){
		return produitService.delProduit(id);
	}
	
	@GetMapping("/{id}")
	public Produit afficheProduit(@PathVariable Long id){
		return produitService.getProduit(id);
	}

}
