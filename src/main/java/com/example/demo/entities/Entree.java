package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Entree {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numEntre;
	private int quantite;
	private Date dateEntre;
	private double prixDentree;
	@ManyToOne
	private Article article;
}
