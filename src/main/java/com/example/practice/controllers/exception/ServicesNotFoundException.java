package com.example.practice.controllers.exception;

public class ServicesNotFoundException extends RuntimeException {
    public ServicesNotFoundException(Long id) {
        super("Не удалось найти услуги " + id);
    }
}