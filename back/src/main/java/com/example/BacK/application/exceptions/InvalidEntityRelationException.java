package com.example.Back.application.exceptions;

public class InvalidEntityRelationException extends RuntimeException {
    public InvalidEntityRelationException(String message) {
        super(message);
    }
}