package com.dymitrmisiejuk.kozliki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootApplication
public class KozlikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KozlikiApplication.class, args);

    }
}
