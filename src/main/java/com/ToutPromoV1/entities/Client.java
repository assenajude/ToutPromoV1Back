package com.ToutPromoV1.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User{
	private String adresse;
	private String tel;
	@OneToMany(mappedBy="client")
	private Collection<Commande>commandes;
	private Collection<LikeVote>likeVotes;
	private Collection<DislikeVote>dislikeVotes;
	public String getAdresse() {
		return adresse;
	}
	public String getTel() {
		return tel;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	public Collection<LikeVote> getLikeVotes() {
		return likeVotes;
	}
	public Collection<DislikeVote> getDislikeVotes() {
		return dislikeVotes;
	}
	public void setLikeVotes(Collection<LikeVote> likeVotes) {
		this.likeVotes = likeVotes;
	}
	public void setDislikeVotes(Collection<DislikeVote> dislikeVotes) {
		this.dislikeVotes = dislikeVotes;
	}
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String name, String username, String email, String password) {
		super(name, username, email, password);
		// TODO Auto-generated constructor stub
	}
	public Client(String adresse, String tel, Collection<Commande> commandes, Collection<LikeVote> likeVotes,
			Collection<DislikeVote> dislikeVotes) {
		this.adresse = adresse;
		this.tel = tel;
		this.commandes = commandes;
		this.likeVotes = likeVotes;
		this.dislikeVotes = dislikeVotes;
	}

}
