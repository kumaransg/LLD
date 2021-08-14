package com.flipkart.orders;

import com.flipkart.users.User;

public class Order {

	
	OrderStatus orderStatus;
	User user;
	String productName;
	Integer quanity;
	
	public Order (OrderStatus orderStatus,User user,String productName)
	{
		this.orderStatus=orderStatus;
		this.productName=productName;
		this.user=user;
		this.quanity=1; //Assumption
		
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}

	@Override
	public String toString() {
		return "Order [orderStatus=" + orderStatus + ", user=" + user.getEmail() + ", productName=" + productName + ", quanity="
				+ quanity + "]";
	}
	
	
	
}
