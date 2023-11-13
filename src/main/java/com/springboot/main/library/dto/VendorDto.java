package com.springboot.main.library.dto;

import com.springboot.main.library.model.User;

public class VendorDto {
	private String name;
	private String email;
	private String contact;
	private User user;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "VendorDto [name=" + name + ", email=" + email + ", contact=" + contact + ", user=" + user + "]";
	}
	

}
