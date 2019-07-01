package com.ToutPromoV1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ToutPromoV1.entities.Espace;
import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.payloads.response.PagedResponse;
import com.ToutPromoV1.repositories.EspaceRepository;
import com.ToutPromoV1.services.EspaceService;
import com.ToutPromoV1.utils.AppConstants;

@RestController
@RequestMapping("/api/espaces")
public class EspaceController {
	
	@Autowired
	private EspaceService espaceService;
	


      @PostMapping("")
	public Espace saveEspace(@Valid @RequestBody Espace espace) {
		return espaceService.addEspace(espace);
		
	}
	
   /*   @GetMapping("/{idEsp}/produits")
	public PagedResponse<Produit> getByEspace(@PathVariable("idEsp") Long idEsp, 
			@RequestParam(value="page", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER)int page,
			@RequestParam(value="size", defaultValue=AppConstants.DEFAULT_PAGE_SIZE)int size){
		return espaceService.getProduitsByEspace(idEsp, page, size);
	}
      */
      @GetMapping("/{idEsp}")
      public Espace findEspace(@PathVariable ("idEsp")Long idEsp) {
    	  return espaceService.getEspace(idEsp);
      }


      @GetMapping("")
      public List<Espace> getAllEspaces(){
      	return espaceService.getEspaces();
	  }
}
