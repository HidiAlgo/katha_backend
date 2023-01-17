package com.katha.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("User")
public class User {


	private String firstName; 
	private String lastName;
	
	@Id
	private String username; // Can be the email or the phone number
	
	private String about;
	
	private String profilePicturePath; // Path of the location where the image is saved
	
	private List<Follower> followers;
	private List<Followee> followees;
	
	private Date dateOfBirth;
	
	private Gender gender;

	public User(String firstName, String lastName, String username, String about, String profilePicturePath,
			List<Follower> followers, List<Followee> followees, Date dateOfBirth, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.about = about;
		this.profilePicturePath = profilePicturePath;
		this.followers = followers;
		this.followees = followees;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}

	public List<Followee> getFollowees() {
		return followees;
	}

	public void setFollowees(List<Followee> followees) {
		this.followees = followees;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", about=" + about
				+ ", profilePicturePath=" + profilePicturePath + ", followers=" + followers + ", followees=" + followees
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}
	
	
}
