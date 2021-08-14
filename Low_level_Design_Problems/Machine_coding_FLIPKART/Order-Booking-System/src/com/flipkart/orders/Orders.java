package com.flipkart.orders;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipart.exception.CustomException;
import com.flipkart.catalog.Catalog;
import com.flipkart.catalog.Product;
import com.flipkart.users.User;
import com.flipkart.users.Users;

public class Orders {
	public static Orders instance = null;
	public static HashMap<String, ArrayList<Order>> emailToOrdersMap = new HashMap<>();
	public static HashMap<String, HashMap<String, Integer>> ordersBookedCountMap = new HashMap<>();

	public static Orders getInstance() {
		if (instance == null) {
			instance = new Orders();
		}
		return instance;
	}

	public void purchase(String email, String productName) throws CustomException {

		Catalog catalog = Catalog.getInstance();
		Product product = catalog.getProductByProductName(productName);
		if (product == null) {
			throw new CustomException("No Product Found", false);
		}

		Users users = Users.getInstance();
		User user = Users.emailToUserMap.get(email);
		if (user == null) {
			user = users.addUser(email);
		}
		if (user.getIsBlacklisted()) {
			throw new CustomException("User is blacklisted", false);
		}

		if (product.getStock() < 1) {
			throw new CustomException("Item is Out Of Stock", false);

		}
		product.setStock(product.getStock() - 1);
		Order order = new Order(OrderStatus.BOOKED, user, productName);

		if (emailToOrdersMap.get(email) != null) {
			emailToOrdersMap.get(email).add(order);
		}

		else {
			ArrayList<Order> orderList = new ArrayList<>();
			orderList.add(order);
			emailToOrdersMap.put(email, orderList);
		}
		updateOrdersBookedCount(product);
	}

	public void updateOrdersBookedCount(Product product) {
		if (ordersBookedCountMap.get(product.getCategoryName()) != null) {
			HashMap<String, Integer> productToBookedCountMap = ordersBookedCountMap.get(product.getCategoryName());

			if (productToBookedCountMap.get(product.getProductCode()) != null) {
				productToBookedCountMap.put(product.getProductCode(),
						productToBookedCountMap.get(product.getProductCode()) + 1);
			} else {
				productToBookedCountMap.put(product.getProductCode(), 1);
			}
		} else {
			HashMap<String, Integer> productToBookedCountMap = new HashMap<>();
			productToBookedCountMap.put(product.getProductCode(), 1);
			ordersBookedCountMap.put(product.getCategoryName(), productToBookedCountMap);
		}
	}

	public void returnProduct(String email, String productName) throws CustomException {

		Catalog catalog = Catalog.getInstance();
		Product product = catalog.getProductByProductName(productName);
		if (product == null) {
			throw new CustomException("No Product Found", false);
		}

		Users users = Users.getInstance();
		User user = Users.emailToUserMap.get(email);
		if (user == null) {
			throw new CustomException("No User Found", false);
		}

		ArrayList<Order> ordersList = emailToOrdersMap.get(email);

		int index = -1;
		Order order = null;
		for (int i = 0; i < ordersList.size(); i++) {
			order = ordersList.get(i);
			if (order.getProductName().equals(productName)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new CustomException("No item found for this user", false);
		}

		order.setOrderStatus(OrderStatus.CANCELLED);
		product.setStock(product.getStock() + 1);
	}

	public Product getBestSellingProductByCategoryName(String categoryName) throws CustomException {
		Catalog catalog = Catalog.getInstance();
		Product product = null;
		if (ordersBookedCountMap.get(categoryName) == null) {
			throw new CustomException("Invalid categoryName", false);
		} else {
			HashMap<String, Integer> productToBookedCountMap = ordersBookedCountMap.get(categoryName);
			int max = 0;

			for (String productName : productToBookedCountMap.keySet()) {
				if (productToBookedCountMap.get(productName) > max) {
					max = productToBookedCountMap.get(productName);

					product = catalog.getProductByProductName(productName);
				}
			}
		}
		return product;
	}

	public void displayAllOrders() {
		for (ArrayList<Order> orders : emailToOrdersMap.values()) {
			for (Order order : orders) {
				System.out.println(order);
			}
		}
	}
}
