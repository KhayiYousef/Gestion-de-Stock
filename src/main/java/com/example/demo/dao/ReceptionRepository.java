package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Reception;
@RepositoryRestResource
public interface ReceptionRepository extends JpaRepository<Reception, Long> {

}
