package com.company.exception;

public class TripStatusException extends RuntimeException {
  public TripStatusException(final String message) {
    super(message);
  }
}
