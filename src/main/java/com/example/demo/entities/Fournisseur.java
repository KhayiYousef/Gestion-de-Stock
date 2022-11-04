package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Fournisseur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numF;
	private String nomF;
	private String address;
	private int codeP;
	private String ville;
	private double payer;
	private String tele;
	private String email;
	private String fax;
	@OneToMany(mappedBy="fournisseur") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Article> article;
	@OneToMany(mappedBy="fournisseur") @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Commande> commande;

}
