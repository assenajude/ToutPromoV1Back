package com.ToutPromoV1.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ToutPromoV1.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

	@Query("SELECT p FROM Produit p where p.idProd=:idprod")
	Produit findOne(@Param("idprod")Long id);
	
	Page<Produit>findProduitsByEspace_EspaceId(Long id, Pageable pageable);

}
