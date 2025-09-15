package com.example.Back.application.mediator;

public interface RequestHandler<C, R> {
    R handle(C command)  ;
}

