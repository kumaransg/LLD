package com.github.akshay.ridesharing.exceptions;

public class NoVehicleRegisteredUnderUserExceptoin extends RuntimeException {
    public NoVehicleRegisteredUnderUserExceptoin(String message) {
        super(message);
    }
}
