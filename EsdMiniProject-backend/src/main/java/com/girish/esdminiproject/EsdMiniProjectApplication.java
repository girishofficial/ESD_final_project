package com.girish.esdminiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.girish.esdminiproject.repo")
@EnableTransactionManagement
public class EsdMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdMiniProjectApplication.class, args);
    }

}
