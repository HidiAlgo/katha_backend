package com.katha.main;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.katha.model.Article;
import com.katha.model.Comment;
import com.katha.model.Followee;
import com.katha.model.Follower;
import com.katha.model.Gender;
import com.katha.model.Like;
import com.katha.model.User;
import com.katha.repositories.ArticleRepository;
import com.katha.repositories.UserRepository;

@ComponentScan(basePackages= {"com.katha"})
@EnableMongoRepositories("com.katha.repositories")
@SpringBootApplication
@Configuration
public class KathaV01Application implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(KathaV01Application.class, args);
	}
	
	public void run(String... args) {
		System.out.println("RUN METHOD");
		createUser();
		createArticle();
	}
	
	public void createUser() {

		
		ArrayList<Follower> followers = new ArrayList<>();
		Follower follower = new Follower("follower@gmail.com", "Follower", "Name");
		followers.add(follower);
		
		ArrayList<Followee> followees = new ArrayList<>();
		Followee followee = new Followee("followee@gmail.com", "Followee", "Name");
		followees.add(followee);
		
		User user = new User(
				"Test",
				"User",
				"username@gmail.com",
				"about description",
				"profile photo path",
				followers,
				followees,
				new Date(),
				Gender.Male
		);
		
		userRepository.save(user);
	}
	
	public void createArticle() {
		Article article = new Article(999, 
				"username@gmail.com",
				"article title",
				new Date(),
				new ArrayList<Like>(),
				new ArrayList<Comment>(),
				"And this is the content"
				);
		
		articleRepository.save(article);
	}

}
