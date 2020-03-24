package com.teste.raspberyaward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.teste.raspberyaward"})
@EnableJpaRepositories("com.teste.raspberyaward")
public class RaspberyawardApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaspberyawardApplication.class, args);
    }

}
