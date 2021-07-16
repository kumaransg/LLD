package com.flipkart.elections.exceptions;

public class CandidateDuplicateEntryException extends Exception {

    public CandidateDuplicateEntryException( String message){
        super(message);
    }
}
