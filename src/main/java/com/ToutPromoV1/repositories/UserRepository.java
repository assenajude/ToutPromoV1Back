package com.ToutPromoV1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToutPromoV1.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User>findByUsernameOrEmail(String username, String email);
	
	List<User>findByIdIn(List<Long> userIds);
	
	Optional<User>findByUsername(String username);
	
	Boolean existsByEmail(String email);

	Boolean existsByUsername(String username);
	

}
