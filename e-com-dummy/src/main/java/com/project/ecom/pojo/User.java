package com.project.ecom.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User {
	
	@Field
	@NotNull
	@Indexed(unique=true)
	private String username;
	
	@Field
	@NotNull
	private String password;
	
	@Field
	@NotNull
	private String contact;
	
	@Id
	@Email(message="Enter a valid emailId.")
	private String email;

	public User() {}
	
	public User(String username, String password, String contact, String email) {
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", contact=" + contact + ", email=" + email
				+ "]";
	}
}
