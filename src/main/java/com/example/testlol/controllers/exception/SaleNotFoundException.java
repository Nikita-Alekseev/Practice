package com.example.testlol.controllers.exception;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException (Long id){super("Could not find sale "+ id);}
}
