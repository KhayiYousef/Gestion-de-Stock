package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeArt;
	private String destignation;
	@Column(length = 75)
	private String unite;
	private int qte;
	private double prix;
	private double newAttr;
	@Column(length = 100)
	private String emplacement;
	@OneToMany(mappedBy="article") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Sortie> sortie;
	@ManyToOne
	private Magasin magasin;
	@OneToMany(mappedBy="article") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Entree> entree;
	@ManyToOne
	private Categorie categorie;
	@OneToMany(mappedBy="article") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<LigneCommande> ligneCommande;
	@ManyToOne
	private Fournisseur fournisseur;

}
