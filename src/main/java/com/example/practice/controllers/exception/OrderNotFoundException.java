package com.example.practice.controllers.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException (Long id){
        super("Не удалось найти заказ " + id);
    }
}