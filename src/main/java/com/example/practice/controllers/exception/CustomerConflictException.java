package com.example.practice.controllers.exception;

public class CustomerConflictException extends RuntimeException {
    public CustomerConflictException(String message){
        super(message);
    }
}
