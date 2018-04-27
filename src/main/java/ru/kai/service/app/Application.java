package ru.kai.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ru.kai.service")
@EnableJpaRepositories(basePackages = "ru.kai.service.repositories")
@EntityScan(basePackages = "ru.kai.service.models")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
