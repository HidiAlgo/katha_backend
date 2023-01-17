package com.katha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("login_details")
public class UserProfile {
	
	@Id
	private String username; 
	private String password;
}
