package com.company.exception;

public class RiderAlreadyPresentException extends RuntimeException {
  public RiderAlreadyPresentException(final String message) {
    super(message);
  }
}
