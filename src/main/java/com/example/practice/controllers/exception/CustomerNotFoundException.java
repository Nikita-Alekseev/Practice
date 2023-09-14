package com.example.practice.controllers.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException (Long id){
        super("Не удалось найти клиента "+ id);
    }
}
