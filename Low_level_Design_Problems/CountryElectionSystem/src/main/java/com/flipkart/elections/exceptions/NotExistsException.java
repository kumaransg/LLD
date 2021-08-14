package com.flipkart.elections.exceptions;

public class NotExistsException extends Exception {
    public NotExistsException(String message) {
        super("Does not exist" + message);
    }
}
