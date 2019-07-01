package com.ToutPromoV1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToutPromoV1.entities.LigneCommande;
import com.ToutPromoV1.services.LigneCommandeService;

@RestController
@RequestMapping("/api/ligneCommandes")
public class LigneCommandeController {
	
	private static final Logger logger = LoggerFactory.getLogger(LigneCommandeController.class);
	
	@Autowired
	private LigneCommandeService ligneCommandeService;
	@PostMapping
	public LigneCommande saveLc( @RequestBody LigneCommande lc) {
		return ligneCommandeService.addLigneCommande(lc);
	}
	
	@PatchMapping
	public LigneCommande updateLc(@RequestBody LigneCommande lc) {
		return ligneCommandeService.updateLc(lc);
	}
	
	@DeleteMapping("/{id}")
	public boolean suppLc(Long id) {
		return ligneCommandeService.delLigneCommande(id);
	}

}
