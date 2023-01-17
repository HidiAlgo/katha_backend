package com.katha.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.katha.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Integer> {
	
	List<Article> findByUsername(String username);
}
