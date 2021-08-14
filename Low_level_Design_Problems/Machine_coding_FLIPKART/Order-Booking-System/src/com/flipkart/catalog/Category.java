package com.flipkart.catalog;

import java.util.ArrayList;
import java.util.HashMap;

public class Category {

	private String categoryName;
	private ArrayList<Product> products = new ArrayList<Product>();
	private HashMap<String, Product> productToStockMap = new HashMap<String, Product>();

	public Category() {

	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public HashMap<String, Product> getProductToStockMap() {
		return productToStockMap;
	}

	public void setProductToStockMap(HashMap<String, Product> productToStockMap) {
		this.productToStockMap = productToStockMap;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		this.productToStockMap.put(product.getProductCode(), product);

	}

	public void removeProduct(String productName) {
		int index = -1;
		for (int i = 0; i < this.products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductCode().equals(productName)) {
				index = i;
				break;
			}
		}
		this.products.remove(index);
		this.productToStockMap.remove(productName);
	}

}
