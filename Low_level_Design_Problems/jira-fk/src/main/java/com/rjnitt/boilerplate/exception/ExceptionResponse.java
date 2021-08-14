package com.rjnitt.boilerplate.exception;

import lombok.Data;

@Data
public class ExceptionResponse {

	private String errorMessage;
	private String callerURL;
	private Integer code;
	private Object response;
	
}
