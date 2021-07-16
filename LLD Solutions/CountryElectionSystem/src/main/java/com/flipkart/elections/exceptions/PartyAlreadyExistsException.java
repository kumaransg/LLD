package com.flipkart.elections.exceptions;

public class PartyAlreadyExistsException extends Exception {
    public PartyAlreadyExistsException(String message){
        super(message + "already exists");
    }
}
