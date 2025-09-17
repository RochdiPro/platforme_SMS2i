package com.example.Back.infrastructure.exceptions;


public class AutomateException extends RuntimeException {
    public AutomateException(String message) {
        super(message);
    }
    public AutomateException(String message, Throwable cause) {
        super(message, cause);
    }
}