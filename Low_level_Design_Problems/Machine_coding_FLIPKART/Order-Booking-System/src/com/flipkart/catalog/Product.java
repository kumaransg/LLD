package com.flipkart.catalog;

public class Product extends Category {

	String productCode;
	Integer stock;

	public Product(String productCode,Integer stock, String categoryName)
	{
		
		this.productCode=productCode;
		this.stock=stock;
		super.setCategoryName(categoryName);
		
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
