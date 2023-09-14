package com.example.practice.controllers.exception;

public class WorkerConflictException extends RuntimeException {
    public WorkerConflictException (String message){super(message);}
}
