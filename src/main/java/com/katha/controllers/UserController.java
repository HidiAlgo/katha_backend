package com.katha.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.katha.model.User;
import com.katha.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/findusers/{username}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable String username) {
		System.out.println("Method got called");
		Optional<User> user = userService.getUser(username);

		if(!user.isEmpty()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User user){

		if(userService.createUser(user)) {
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		System.out.println(user);
		
		if(userService.createUser(user)) {
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
