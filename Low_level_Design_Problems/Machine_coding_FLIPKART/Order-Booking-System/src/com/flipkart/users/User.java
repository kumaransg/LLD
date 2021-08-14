package com.flipkart.users;

public class User {

	String email;
	Boolean isBlacklisted;

	public User(String email, boolean isBlacklisted) {
		this.email = email;
		this.isBlacklisted = isBlacklisted;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsBlacklisted() {
		return isBlacklisted;
	}

	public void setIsBlacklisted(Boolean isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

}
