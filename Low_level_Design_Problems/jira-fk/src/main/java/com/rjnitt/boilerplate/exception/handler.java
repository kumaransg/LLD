package com.rjnitt.boilerplate.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class handler {

	@ExceptionHandler({ ResourceNotFoundException.class, IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setCallerURL(request.getRequestURI());
		error.setCode(HttpStatus.NOT_FOUND.value());

		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse exception(final Exception exception, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setCallerURL(request.getRequestURI());
		error.setCode(HttpStatus.NOT_FOUND.value());

		return error;
	}
}
