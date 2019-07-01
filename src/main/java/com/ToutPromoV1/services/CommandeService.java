package com.ToutPromoV1.services;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ToutPromoV1.entities.Commande;
import com.ToutPromoV1.entities.LigneCommande;
import com.ToutPromoV1.entities.Panier;
import com.ToutPromoV1.payloads.response.CommandeResponse;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.repositories.CommandeRepository;
import com.ToutPromoV1.repositories.LigneCommandeRepository;

@Service
public class CommandeService {
	
	private static final Logger logger=LoggerFactory.getLogger(CommandeService.class);
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	
	public PagedResponse<Commande> getAllCommandes(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Commande>commandes = commandeRepository.findAll(pageable);
		
		return new PagedResponse<>(commandes.getContent(), commandes.getNumber(), commandes.getSize(), commandes.getTotalElements(),commandes.getTotalPages(), commandes.isLast());
		
	}
	
	public Commande createCommande(Commande cmde) {
		return commandeRepository.save(cmde);
		
	}
	
	public Commande saveCommande( Commande c, Panier p) {
		//Commande cmd = new Commande();
		c.setDateCreated(new Date());
		c.setLigneCommandes(p.getItems());
		for(LigneCommande lc:p.getItems()) {
			ligneCommandeRepository.save(lc);
		}
		commandeRepository.save(c);
		return c;
		
	}
	
	public void updateCommande(Commande cmde) {
		commandeRepository.save(cmde);
	}

}
