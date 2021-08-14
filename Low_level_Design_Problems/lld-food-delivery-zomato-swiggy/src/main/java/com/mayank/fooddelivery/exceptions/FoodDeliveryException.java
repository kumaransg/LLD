package com.mayank.fooddelivery.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FoodDeliveryException extends RuntimeException {
    private ExceptionType exceptionType;
    private String message;
}
