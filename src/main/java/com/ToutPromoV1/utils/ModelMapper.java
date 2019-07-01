package com.ToutPromoV1.utils;

import java.time.Instant;
import java.util.Map;

import com.ToutPromoV1.entities.Produit;
import com.ToutPromoV1.entities.User;
import com.ToutPromoV1.payloads.response.ProduitResponse;

public class ModelMapper {
	
/*	public static ProduitResponse mapProduitToProduitResponse(Produit produit,Map<Long, Long>produitLikeVoteMap,Map<Long,Long>produitDislikeVoteMap,Map<Long,Long>userCommande,Long userVote, User voter  ) {
		ProduitResponse produitResponse = new ProduitResponse();
		produitResponse.setId(produit.getIdProd());
		produitResponse.setDesignProd(produit.getDesignProd());
		produitResponse.setDescripProd(produit.getDescripProd());
		produitResponse.setPrixProd(produit.getPrixProd());
		produitResponse.setPrixminProd(produit.getPrixminProd());
		produitResponse.setPrixmaxProd(produit.getPrixmaxProd());
		produitResponse.setQteStockProd(produit.getQteStockProd());
		produitResponse.setInfosMarque(produit.getInfosMarque());
		produitResponse.setEspace(produit.getEspace().getEspaceName());
		produitResponse.setExpirationDateTime(produit.getExpirationDate());
		Instant now = Instant.now(); 
		produitResponse.setIsExpired(produit.getExpirationDate().isBefore(now));
	}*/

}
