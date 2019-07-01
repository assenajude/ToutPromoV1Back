package com.ToutPromoV1.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

public class Panier implements Serializable{
	private Map<Long, LigneCommande>items=new HashMap<Long, LigneCommande>();
	
	@Transient
	public void addProd(Produit p, int quantite) {
		if(items.get(p.getIdProd())==null) {
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setPrice(p.getPrixProd());
			lc.setQuantite(quantite);
		}else {
			LigneCommande lc = items.get(p.getIdProd());
			lc.setQuantite(lc.getQuantite()+quantite);
			lc.setPrice(p.getPrixProd());
		}
		
	}
	
	@Transient
	public Collection<LigneCommande> getItems(){
		return items.values();
	}
	
	@Transient
	public double getTotal() {
		double total=0;
		for(LigneCommande lc:items.values()) {
			total +=lc.getPrice()*lc.getQuantite();
		}
		return total; 
		
	}
	
	@Transient
	public int getSize() {
		return items.size(); 
	}
	
	@Transient
	public void delItem(Long idProd) {
		items.remove(idProd);
	}
		
/*
	@EmbeddedId
	@JsonIgnore
	private LigneCommande lc;
	
	@Column(nullable=false)
	private int quantite;
	
	public Panier(Commande commande, Produit produit, int quantite) {
		lc=new LigneCommande();
		lc.setCommande(commande);
		lc.setProduit(produit);
		this.quantite=quantite;
	}
	

	@Transient
	public Produit getProduit() {
		return this.lc.getProduit();
	}
	
	@Transient
	public Double getTotalPrice() {
		return getProduit().getPrixProd()*getQuantite();
	}

	public LigneCommande getLc() {
		return lc;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setLc(LigneCommande lc) {
		this.lc = lc;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lc == null) ? 0 : lc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Panier other = (Panier) obj;
		if (lc == null) {
			if (other.lc != null)
				return false;
			
		} else if (!lc.equals(other.lc))
			return false;
		
		return true;
	}*/
	
	
	
}
