package com.ToutPromoV1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToutPromoV1.entities.RoleName;
import com.ToutPromoV1.entities.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	
	Optional<Roles>findByName(RoleName roleName);

}
