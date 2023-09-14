package com.example.practice.controllers.exception;

public class ServicesConflictException extends RuntimeException {
    public ServicesConflictException (String message){
        super(message);
    }
}
