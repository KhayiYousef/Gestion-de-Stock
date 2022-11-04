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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sortie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numS;
	private int quantite;
	private double prix;
	private Date dateSortie;
	@ManyToOne
	private Article article;

}
