package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Ligne_Commande")
public class LigneCommande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantiteCmd;
	private double prix;
	private double montant;
	@ManyToOne
	private Article article;
	@ManyToOne
	private Commande commande;

}
