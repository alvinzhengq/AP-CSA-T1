package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team {
    @GetMapping("/team")
    public String team() {
        return "team"; // returns HTML VIEW (greeting)
    }
}
