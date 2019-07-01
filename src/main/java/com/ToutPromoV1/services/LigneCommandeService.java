package com.ToutPromoV1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToutPromoV1.entities.LigneCommande;
import com.ToutPromoV1.entities.Panier;
import com.ToutPromoV1.repositories.LigneCommandeRepository;

@Service
public class LigneCommandeService {
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	
	public LigneCommande addLigneCommande(LigneCommande lc) {
		
		
		return ligneCommandeRepository.save(lc);
	}
	
	public boolean delLigneCommande(Long idLc ) {
		ligneCommandeRepository.deleteById(idLc);
		return true;
	}
	
	public LigneCommande updateLc(LigneCommande lc) {
		
		return ligneCommandeRepository.save(lc);
	}
	

}
