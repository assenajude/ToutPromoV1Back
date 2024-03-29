package com.ToutPromoV1.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ToutPromoV1.entities.RoleName;
import com.ToutPromoV1.entities.Roles;
import com.ToutPromoV1.entities.User;
import com.ToutPromoV1.exception.AppExecption;
import com.ToutPromoV1.payloads.request.LoginRequest;
import com.ToutPromoV1.payloads.request.SignUpRequest;
import com.ToutPromoV1.payloads.response.ApiResponse;
import com.ToutPromoV1.payloads.response.JwtAuthenticationResponse;
import com.ToutPromoV1.repositories.RoleRepository;
import com.ToutPromoV1.repositories.UserRepository;
import com.ToutPromoV1.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	  @PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsernameOrEmail(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = tokenProvider.generateToken(authentication);
	        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	    }
	
	@PostMapping("signup")
	public ResponseEntity<?>registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email address already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		User user = new User(signUpRequest.getName(),signUpRequest.getUsername(),
				      signUpRequest.getEmail(),signUpRequest.getPassword());
		
		       user.setPassword(passwordEncoder.encode(user.getPassword()));
		       
		       Roles userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(()->
		       new AppExecption("User role not set"));
		       
		       user.setRoles(Collections.singleton(userRole));
		       
		       User result = userRepository.save(user);
		       
		       URI location = ServletUriComponentsBuilder
		    		   .fromCurrentContextPath().path("/api/users/{username}")
		    		   .buildAndExpand(result.getUsername()).toUri();
		       
		       return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
	
	
	
	

}
