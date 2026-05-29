package com.gavea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gavea.repositorio")
public class GaveaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaveaApplication.class, args);
    }
}