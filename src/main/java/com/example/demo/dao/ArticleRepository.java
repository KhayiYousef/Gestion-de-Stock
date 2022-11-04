package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.entities.Article;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
	@Query("select article from Article article where article.destignation like :dest")
	public Page<Article> articleParDestignation(@Param("dest") String destignation,Pageable pageable);

}
