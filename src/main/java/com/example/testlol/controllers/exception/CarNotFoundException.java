package com.example.testlol.controllers.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Long id) {
        super("Could not find buyer " + id);
    }
}
