package com.katha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Follower")
public class Follower {
	
	@Id
	private String follower_username;
	private String follower_first_name;
	private String follower_last_name;
	
	public Follower(String follower_username, String follower_first_name, String follower_last_name) {
		super();
		this.follower_username = follower_username;
		this.follower_first_name = follower_first_name;
		this.follower_last_name = follower_last_name;
	}

	public String getFollower_username() {
		return follower_username;
	}

	public void setFollower_username(String follower_username) {
		this.follower_username = follower_username;
	}

	public String getFollower_first_name() {
		return follower_first_name;
	}

	public void setFollower_first_name(String follower_first_name) {
		this.follower_first_name = follower_first_name;
	}

	public String getFollower_last_name() {
		return follower_last_name;
	}

	public void setFollower_last_name(String follower_last_name) {
		this.follower_last_name = follower_last_name;
	}

	@Override
	public String toString() {
		return "Follower ["  + ", follower_username=" + follower_username + ", follower_first_name="
				+ follower_first_name + ", follower_last_name=" + follower_last_name + "]";
	}
	
	
	
}
