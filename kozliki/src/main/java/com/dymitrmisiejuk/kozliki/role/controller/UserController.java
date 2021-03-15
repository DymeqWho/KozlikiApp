package com.dymitrmisiejuk.kozliki.role.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Zalogowany jako: " + user.getUsername() + " " + localDateTime);

        return user.getUsername();
    }

}
