package com.ToutPromoV1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ToutPromoV1.entities.Espace;
import com.ToutPromoV1.entities.Produit;

public interface EspaceRepository extends JpaRepository<Espace, Long> {


}
