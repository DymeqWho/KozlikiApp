package com.dymitrmisiejuk.kozliki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootApplication
public class KozlikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KozlikiApplication.class, args);

//        INFO: only for testing purpose:
//        String password = "password";
//        String password2 = "admin";
//
//        System.out.println("{bcrypt}: " + PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password));
//        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password2));
    }
}
