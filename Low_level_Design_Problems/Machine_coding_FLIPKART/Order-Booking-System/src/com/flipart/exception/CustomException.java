package com.flipart.exception;

public class CustomException extends Exception {

	String message;
	boolean status;

	public CustomException(String message, boolean status) {

		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

}
