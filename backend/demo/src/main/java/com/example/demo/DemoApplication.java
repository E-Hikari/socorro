package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

@SpringBootApplication
@EnableReactiveNeo4jRepositories
public class DemoApplication {

    // O método para rodar a aplicação
    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot.
        SpringApplication.run(DemoApplication.class, args);
    }

}

