package com.example.paekaempay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PaekaemPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaekaemPayApplication.class, args);
    }

}
