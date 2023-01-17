package com.katha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Like")
public class Like {
	@Id
	private String likedPersonUsername;

	public Like(String likedPersonUsername) {
		super();
		this.likedPersonUsername = likedPersonUsername;
	}

	public String getLikedPersonUsername() {
		return likedPersonUsername;
	}

	public void setLikedPersonUsername(String likedPersonUsername) {
		this.likedPersonUsername = likedPersonUsername;
	}
	
}
