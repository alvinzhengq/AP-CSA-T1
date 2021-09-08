package com.example.sping_portfolio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Login {
    @GetMapping("/mvfetch/login")
    public String login() {
        return "mvfetch/login";
    }
}
