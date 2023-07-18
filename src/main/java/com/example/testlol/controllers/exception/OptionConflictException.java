package com.example.testlol.controllers.exception;

public class OptionConflictException extends RuntimeException {
    public OptionConflictException (String message){
        super(message);
    }
}
