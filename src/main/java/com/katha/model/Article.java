package com.katha.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Article")
public class Article {
	
	@Transient
	public static final String SEQUENCE_NAME = "article_sequence";
	
	@Id
	private long id;
	private String username;
	private String title;
	private Date articleDate;
	
	private List<Like> likes = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	
	private String articleContent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Article(long id, String username, String title, Date articleDate, List<Like> likes, List<Comment> comments,
			String articleContent) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.articleDate = articleDate;
		this.likes = likes;
		this.comments = comments;
		this.articleContent = articleContent;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", username=" + username + ", title=" + title + ", articleDate=" + articleDate
				+ ", likes=" + likes + ", comments=" + comments + ", articleContent=" + articleContent + "]";
	}

	
}
