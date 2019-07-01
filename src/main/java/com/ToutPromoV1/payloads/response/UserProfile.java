package com.ToutPromoV1.payloads.response;

import java.time.Instant;
import java.util.Collection;

public class UserProfile {
	
	private Long id;
	private String username;
	private String name;
	private Instant joinedAt;
	private Collection<CommandeResponse>listCommandes;
	private Collection<UserProduitLikeVoteResponse>produitsLiked;
	private Collection<UserProduitDislikeVoteResponse>produitsDisliked;
	
	public UserProfile(Long id, String username, String name, Instant joinedAt,
			Collection<CommandeResponse> listCommandes, Collection<UserProduitLikeVoteResponse> produitsLiked,
			Collection<UserProduitDislikeVoteResponse> produitsDisliked) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.joinedAt = joinedAt;
		this.listCommandes = listCommandes;
		this.produitsLiked = produitsLiked;
		this.produitsDisliked = produitsDisliked;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	public Collection<CommandeResponse> getListCommandes() {
		return listCommandes;
	}

	public Collection<UserProduitLikeVoteResponse> getProduitsLiked() {
		return produitsLiked;
	}

	public Collection<UserProduitDislikeVoteResponse> getProduitsDisliked() {
		return produitsDisliked;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
	}

	public void setListCommandes(Collection<CommandeResponse> listCommandes) {
		this.listCommandes = listCommandes;
	}

	public void setProduitsLiked(Collection<UserProduitLikeVoteResponse> produitsLiked) {
		this.produitsLiked = produitsLiked;
	}

	public void setProduitsDisliked(Collection<UserProduitDislikeVoteResponse> produitsDisliked) {
		this.produitsDisliked = produitsDisliked;
	}
	
	
	
	
	

}
