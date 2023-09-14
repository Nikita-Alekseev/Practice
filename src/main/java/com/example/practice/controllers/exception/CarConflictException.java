package com.example.practice.controllers.exception;

public class CarConflictException extends RuntimeException {
    public CarConflictException(String message) {
        super(message);
    }
}
