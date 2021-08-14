package com.company.exception;

public class TripNotFoundException extends RuntimeException {
  public TripNotFoundException(final String message) {
    super(message);
  }
}
