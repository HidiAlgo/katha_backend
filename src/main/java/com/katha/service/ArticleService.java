package com.katha.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.katha.model.Article;
import com.katha.model.DBSequence;
import com.katha.repositories.ArticleRepository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	MongoOperations mongoOperations;
	
	public Optional<Article> getArticle(int id){
		Query query = new Query(Criteria.where("id").is(id));
		return Optional.ofNullable(mongoOperations.findOne(query, Article.class));
	}
	
	public List<Article> getAllArticles(){
		return articleRepository.findAll();
	}
	
	public List<Article> getArticlesByUser(String username){
		return articleRepository.findByUsername(username);
	}
	
	public Optional<Article> createArticle(Article article) {
		Query query = new Query(Criteria.where("id").is(article.SEQUENCE_NAME));
		Update update = new Update().inc("seq", 1);
		
		DBSequence counter = mongoOperations.findAndModify(query, 
				update,
				options().returnNew(true).upsert(true), 
				DBSequence.class);
		
		long id = !Objects.isNull(counter)?counter.getSeq():1;
		
		article.setId(id);
		
		try {
			articleRepository.save(article);
			return Optional.of(article);
		}catch(Exception e) {
			return Optional.empty();
		}
	}
	
	public Optional<Article> updateArticle(Article article){
		try {
			articleRepository.save(article);
			return Optional.of(article);
		}catch(Exception e) {
			return Optional.empty();
		}
	}
}
