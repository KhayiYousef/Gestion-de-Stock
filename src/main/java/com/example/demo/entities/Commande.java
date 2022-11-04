package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

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

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCmd;
	private Date dateCmd;
	@Column(length = 75)
	private String etat;
	@ManyToOne
	private Reception reception;
	@ManyToOne
	private Fournisseur fournisseur;
	@OneToMany(mappedBy="commande") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<LigneCommande> ligneCommande;

}
