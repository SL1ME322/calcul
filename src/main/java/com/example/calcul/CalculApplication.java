package com.example.calcul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class CalculApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculApplication.class, args);
    }
}
