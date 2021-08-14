package com.flipkart.catalog;

import java.util.ArrayList;
import java.util.HashMap;

import com.flipart.exception.CustomException;

public class Catalog {

	public static HashMap<String, Category> categories;
	public static Catalog instance = null;

	private Catalog() {
		categories = new HashMap<String, Category>();
	}

	public static Catalog getInstance() {
		if (instance == null) {
			instance = new Catalog();
		}
		return instance;
	}

	public static void addProduct(String productName, String categoryName, Integer stock) throws CustomException {
		if (categories.get(categoryName) != null) {

			if (categories.get(categoryName).getProductToStockMap().get(productName)== null) {

				Product product = new Product(productName, stock, categoryName);
				Category category = categories.get(categoryName);
				category.addProduct(product);
				categories.put(categoryName, category);
			} else {

				throw new CustomException("Items already exists", false);

			}
		} else {

			Category category = new Category(categoryName);
			Product product = new Product(productName, stock, categoryName);
			category.addProduct(product);
			categories.put(categoryName, category);

		}
	}

	public static void removeProduct(String productName) throws CustomException {
		boolean flag = false;
		for (Category category : categories.values()) {
			if (category.getProductToStockMap().containsKey(productName)) {
				flag = true;
				category.removeProduct(productName);
			}
		}
		if (flag == false) {
			throw new CustomException("Could not find the item", false);

		}
	}

	public Product getProductByProductName(String productName) {
		for (Category category : categories.values()) {
			if (category.getProductToStockMap().containsKey(productName)) {
				return category.getProductToStockMap().get(productName);
			}
		}
		return null;
	}

	public void displayInventory() {
		for (Category category : categories.values()) {
			for (String productName : category.getProductToStockMap().keySet()) {
				System.out.println("ProductName :" + productName + " Stock:"
						+ category.getProductToStockMap().get(productName).getStock());
			}
		}
	}
}
