package com.ToutPromoV1.services;



import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import com.ToutPromoV1.payloads.request.ProduitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.exception.BadRequestException;
import com.ToutPromoV1.exception.ResourceNotFoundException;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.repositories.ProduitRepository;
import com.ToutPromoV1.utils.AppConstants;

@Service
public class ProduitService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduitService.class);
	
	@Autowired
	private ProduitRepository produitRepository;
	
	
	public Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}
	
	public PagedResponse<Produit> getAllProduits(int page, int size){
	validatePageNumberAndSize(page, size);
	
	Pageable pageable = PageRequest.of(page, size);
	Page<Produit>produits = produitRepository.findAll(pageable);
	
		return new PagedResponse<>(produits.getContent(),produits.getNumber(),produits.getSize(),
				produits.getTotalElements(),produits.getTotalPages(),produits.isLast());
		}
	
	public Produit modifProduit(ProduitRequest p, Long id) {
		Instant now=Instant.now();
		Instant expirationDateTime = now.plus(Duration.ofDays(p.getTimeLenght().getDays()))
				.plus(Duration.ofHours(p.getTimeLenght().getHours()));
		return produitRepository.findById(id)
				.map(produit->{
					produit.setIdProd(p.getIdProd());
					produit.setDesignProd(p.getDesignProd());
					produit.setDescripProd(p.getDescripProd());
					produit.setInfosMarque(p.getInfosMarque());
					produit.setExpirationDate(expirationDateTime);
					produit.setLienImage(p.getLienImage());
					produit.setNomImage(p.getNomImage());
					produit.setEspace(p.getEspace());
					produit.setPrixProd(p.getPrixProd());
					produit.setPrixminProd(p.getPrixminProd());
					produit.setPrixmaxProd(p.getPrixmaxProd());
					produit.setTotalVotant(p.getTotalVotant());
					produit.setCurrentVotant(p.getCurrentVotant());
					produit.setPercent(p.getPercent());
					produit.setQteStockProd(p.getQteStockProd());
					produit.setGoSpin(p.isGoSpin());
					produit.setPanelCollapsed(p.isPanelCollapsed());
					return produitRepository.save(produit);
				}).orElseThrow(()->new ResourceNotFoundException("Impossible de faire la mise à jour veillez reessayer plutard"+id));
	}
	
	public ResponseEntity<?>delProduit(Long id){
		return produitRepository.findById(id)
				.map(produit->{
					produitRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElseThrow(()->new ResourceNotFoundException("Le produit que voulez supprimer n'existe pas"+id));
	}
	
	
	public Produit getProduit(@Min(value = 1, message = "invalid product id")long id){
		return produitRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("produit introuvable"));
	}

	public PagedResponse<Produit> getProduitsByEspace(Long id, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Produit> produitsByEspace = produitRepository.findProduitsByEspace_EspaceId(id, pageable);
		return new PagedResponse<>(produitsByEspace.getContent(), produitsByEspace.getNumber(), produitsByEspace.getSize(), produitsByEspace.getTotalElements(), produitsByEspace.getTotalPages(), produitsByEspace.isLast());

	}

	public Page<Produit> getProduitEspace(Long idEsp, Pageable pageable){
		return produitRepository.findProduitsByEspace_EspaceId(idEsp, pageable);
	}
		private void validatePageNumberAndSize(int page, int size) {
		if(page<0) {
			throw new BadRequestException("le numero de la page ne doit pas inferieur à zero.");
		}
		if(size>AppConstants.MAX_PAGE_SIZE) {
			throw new BadRequestException("La taille d'un page ne doit pas etre superieure à"+AppConstants.MAX_PAGE_SIZE);
		}
	}
	
	}
