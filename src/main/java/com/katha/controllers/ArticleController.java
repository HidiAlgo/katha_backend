package com.katha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.katha.model.Article;
import com.katha.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Article>> getAll(){
		return new ResponseEntity<> (articleService.getAllArticles(), HttpStatus.OK);
	}
	
	@GetMapping("/oneuser/{username}")
	public ResponseEntity<List<Article>> getAllForUser(@PathVariable String username){
		return new ResponseEntity<>(articleService.getArticlesByUser(username), HttpStatus.OK);
	}
	
	@GetMapping("/onearticle/{articleid}")
	public ResponseEntity<Article> getOne(@PathVariable int articleid){
		Optional<Article> article = articleService.getArticle(articleid); 
		
		if(!article.isEmpty()) {
			return new ResponseEntity<>(article.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/createarticle")
	public ResponseEntity<Article> createArticle(@RequestBody Article article){
		Optional<Article> saved_article = articleService.createArticle(article);
		
		if(!saved_article.isEmpty()) {
			return new ResponseEntity<>(saved_article.get(), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/updatearticle")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article){
		
		Optional<Article> updated_article = articleService.updateArticle(article);
		
		if(!updated_article.isEmpty()) {
			return new ResponseEntity<>(updated_article.get(), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
