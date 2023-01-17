package com.katha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Followee")
public class Followee {
	
	@Id
	private String followee_username;
	private String followee_first_name;
	private String followee_last_name;
	
	public Followee(String followee_username, String followee_first_name, String followee_last_name) {
		this.followee_username = followee_username;
		this.followee_first_name = followee_first_name;
		this.followee_last_name = followee_last_name;
	}

	public String getFollowee_username() {
		return followee_username;
	}

	public void setFollowee_username(String followee_username) {
		this.followee_username = followee_username;
	}

	public String getFollowee_first_name() {
		return followee_first_name;
	}

	public void setFollowee_first_name(String followee_first_name) {
		this.followee_first_name = followee_first_name;
	}

	public String getFollowee_last_name() {
		return followee_last_name;
	}

	public void setFollowee_last_name(String followee_last_name) {
		this.followee_last_name = followee_last_name;
	}

	@Override
	public String toString() {
		return "Followee [followee_username=" + followee_username + ", followee_first_name=" + followee_first_name
				+ ", followee_last_name=" + followee_last_name + "]";
	}
	
	
}
