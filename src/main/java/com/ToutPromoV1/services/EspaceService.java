package com.ToutPromoV1.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ToutPromoV1.entities.Espace;
import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.exception.ResourceNotFoundException;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.repositories.EspaceRepository;
import com.ToutPromoV1.repositories.ProduitRepository;

@Service
public class EspaceService {
	
	private static final Logger logger=LoggerFactory.getLogger(EspaceService.class);
	
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private EspaceRepository esppaceRepository;
	
	

	public Espace addEspace(Espace esp) {
		return esppaceRepository.save(esp);
		
	}
	
/*	public PagedResponse<Produit> getProduitsByEspace(Long id, int page, int size){
		Pageable pageable=PageRequest.of(page, size);
		Page<Produit>produitsByEspace = esppaceRepository.findByEspaceId(id, pageable);
		return new PagedResponse<>(produitsByEspace.getContent(), produitsByEspace.getNumber(), produitsByEspace.getSize(), produitsByEspace.getTotalElements(), produitsByEspace.getTotalPages(), produitsByEspace.isLast());
		
		
	}*/
	
	public Espace getEspace(Long id) {
		return esppaceRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("l'espace que vous cherchez n'existe pas"));
	}

	public List<Espace> getEspaces(){
		return esppaceRepository.findAll();
	}

}
