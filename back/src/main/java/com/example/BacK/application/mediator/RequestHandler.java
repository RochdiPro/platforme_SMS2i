package com.example.MESBack.application.mediator;

public interface RequestHandler<C, R> {
    R handle(C command)  ;
}

