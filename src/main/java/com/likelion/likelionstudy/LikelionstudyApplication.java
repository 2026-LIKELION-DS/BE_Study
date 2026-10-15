package com.likelion.likelionstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.likelion.likelionstudy.class8")
public class LikelionstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LikelionstudyApplication.class, args);
    }
}