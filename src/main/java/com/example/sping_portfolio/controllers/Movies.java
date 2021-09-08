package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Movies {
    @GetMapping("/mvfetch/movies")
    public String movies() {
        return "mvfetch/movies";
    }
}
