package com.flipkart.users;

import java.util.HashMap;

import com.flipkart.orders.Orders;

public class Users {

	public static Users instance = null;
	public static HashMap<String, User> emailToUserMap;

	public static Users getInstance() {
		if (instance == null) {
			instance = new Users();
		}
		return instance;
	}

	protected Users() {
		emailToUserMap = new HashMap<String, User>();
	}

	public User addUser(String email) {

		User user = new User(email, false);
		emailToUserMap.put(email, user);
		return user;
	}

	public void blacklistUser(String email) {

		User user = emailToUserMap.get(email);
		if (user == null) {
			user = addUser(email);
		}
		user.setIsBlacklisted(true);
		Orders orders = Orders.getInstance();
		orders.emailToOrdersMap.remove(email);
	}

}
