package com.example.MESBack.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public Interceptor Interceptor() {
        return new Interceptor();
    }

    @SuppressWarnings("null")
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // Origines autorisées : Angular dev + Capacitor
                .allowedOrigins(
                         
                        "http://localhost:4200",
                        "http://192.168.1.43:4200",
                        "http://192.168.1.232",
                        "capacitor://localhost"
                )
                .allowedMethods("*")
                .allowedHeaders("*");
              //  .allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(Interceptor());
    }
}