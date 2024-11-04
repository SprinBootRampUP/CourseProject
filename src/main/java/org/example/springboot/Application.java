package org.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.model.Author;
import org.example.springboot.service.AuthorService;
import org.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.springboot.repository")
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Hello World!");
    }




}
