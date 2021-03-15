package com.dymitrmisiejuk.kozliki.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @RequestMapping("/login.html")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
