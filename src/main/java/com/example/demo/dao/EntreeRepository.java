package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Entree;
@RepositoryRestResource
public interface EntreeRepository extends JpaRepository<Entree, Long> {

}
