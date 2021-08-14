package com.flipkart.orders;

public enum OrderStatus {

	BOOKED("Booked"), CANCELLED("Cancelled");
	String code;

	private OrderStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
