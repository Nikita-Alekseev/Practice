package com.example.practice.controllers.exception;

public class OrderConflictException extends RuntimeException {
    public OrderConflictException (String message){
        super(message);
    }
}
