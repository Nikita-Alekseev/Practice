package com.example.practice.controllers.exception;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException (Long id){super("Не удалось найти работника "+ id);}
}
