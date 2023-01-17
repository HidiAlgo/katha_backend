package com.katha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	@Id
	private String commentAddedUsername;
	private String comment;
	
	public Comment(String commentAddedUsername, String comment) {
		super();
		this.commentAddedUsername = commentAddedUsername;
		this.comment = comment;
	}

	public String getCommentAddedUsername() {
		return commentAddedUsername;
	}

	public void setCommentAddedUsername(String commentAddedUsername) {
		this.commentAddedUsername = commentAddedUsername;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
