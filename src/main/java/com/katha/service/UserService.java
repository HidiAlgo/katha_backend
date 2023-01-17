package com.katha.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katha.model.Followee;
import com.katha.model.Follower;
import com.katha.model.Gender;
import com.katha.model.User;
import com.katha.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getUser(String username) {
		return userRepository.findById(username);
	}
	
	public boolean createUser(User user) {
		System.out.println("createUser method");
		try {
			userRepository.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
