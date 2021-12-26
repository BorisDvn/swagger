package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SwaggerApplication.class, args);
    }

}
