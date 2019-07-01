package com.ToutPromoV1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ToutPromoV1.entities.Commande;
import com.ToutPromoV1.entities.Panier;
import com.ToutPromoV1.entities.StatutCommande;
import com.ToutPromoV1.payloads.response.LignePanierResponse;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.services.CommandeService;
import com.ToutPromoV1.services.ProduitService;
import com.ToutPromoV1.utils.AppConstants;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandeController.class);
	
	
	private CommandeService commandeService;
	
	
	private ProduitService produitService;

	
	public CommandeController(CommandeService commandeService, ProduitService produitService) {
		this.commandeService = commandeService;
		this.produitService = produitService;
		
	}

	@GetMapping
	public PagedResponse<Commande> afficcheTousCommandes(@RequestParam(value="page", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER)int page, @RequestParam(value="size", defaultValue=AppConstants.DEFAULT_PAGE_SIZE)int size){
		return commandeService.getAllCommandes(page, size);
	}

/*	@PostMapping
	public ResponseEntity<Commande>addCmde(@RequestBody CommandeForm form){
		List<LignePanierResponse>panierForms = form.getLigneCommandes();
		validateProduitExistence(panierForms);
		Commande commande = new Commande();
		commande.setStatutPayement(StatutCommande.values().toString());
		commande =this.commandeService.createCommande(commande);
		List<Panier> paniers = new ArrayList<>();
		for(LignePanierResponse lpr:panierForms) {
			paniers.add(panierService.createPanier(new Panier(commande, produitService.getProduit(lpr
					.getProduit()
					.getIdProd()), lpr.getQteCmde())));
		}
		commande.setPaniers(paniers);
		this.commandeService.updateCommande(commande);
		String uri = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.path("/commande/{id}")
				.buildAndExpand(commande.getIdCmde())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", uri);
		return new ResponseEntity<>(commande, headers,HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public Commande addCommande(@RequestBody Commande c, Panier p) {
		return commandeService.saveCommande(c, p);
	}
	
	private void validateProduitExistence(List<LignePanierResponse>lignePaniers) {
		List<LignePanierResponse>listPaniers = lignePaniers
				.stream()
				.filter(op->Objects.isNull(produitService.getProduit(op
						.getProduit()
						.getIdProd())))
				       .collect(Collectors.toList());
		
		if(!CollectionUtils.isEmpty(listPaniers)) {
			new ResourceNotFoundException("Produit introuvable");
		}
	}
	
	public static class CommandeForm{
		
		
		private List<LignePanierResponse> ligneCommandes;

		public List<LignePanierResponse> getLigneCommandes() {
			return ligneCommandes;
		}

		public void setLigneCommandes(List<LignePanierResponse> ligneCommandes) {
			this.ligneCommandes = ligneCommandes;
		}
		
		
	}

}
