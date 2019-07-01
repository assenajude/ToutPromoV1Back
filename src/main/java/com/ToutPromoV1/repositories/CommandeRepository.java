package com.ToutPromoV1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToutPromoV1.entities.Commande;
import com.ToutPromoV1.entities.LigneCommande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long>{
	
	//public LigneCommande saveLc(LigneCommande lc);

}
