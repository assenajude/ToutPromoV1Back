package com.ToutPromoV1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ToutPromoV1.entities.audit.DateAudit;

@Entity
@Table(name="likeVotes", uniqueConstraints= {
		@UniqueConstraint(columnNames= {
				"user_id",
				"id_prod"
		})
})
public class LikeVote extends DateAudit {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_prod", nullable=false)
	private Produit produit;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="espace_id", nullable=false)
	private Espace espace;

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Produit getProduit() {
		return produit;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	

}
