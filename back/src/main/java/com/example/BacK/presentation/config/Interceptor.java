package com.example.BacK.presentation.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //User.idUser = "f8d1c96b-72f2-40ba-bccc-b597480d6780";// UUID.fromString("f8d1c96b-72f2-40ba-bccc-b597480d6780");
        return true;
    }


}
