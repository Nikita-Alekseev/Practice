package com.example.testlol.controllers.exception;

public class OptionNotFoundException extends RuntimeException {
    public OptionNotFoundException (Long id){
        super("Could not find option " + id);
    }
}
