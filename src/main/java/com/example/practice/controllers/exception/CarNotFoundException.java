package com.example.practice.controllers.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Long id) {
        super("Не удалось найти покупателя " + id);
    }
}
