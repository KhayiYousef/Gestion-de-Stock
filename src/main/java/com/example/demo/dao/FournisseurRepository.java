package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.entities.Fournisseur;

@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
	@Query("select fournisseur from Fournisseur fournisseur where fournisseur.nomF like :nom")
	public Page<Fournisseur> fournisseurParFournisseur(@Param("nom") String nom,Pageable pageable);

}
