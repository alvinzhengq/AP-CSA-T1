package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlvinRGBLab {

    @GetMapping("/AlvinRGBLab")
    public String getAlvinRGBLab() {
        return "AlvinRGBLab";
    }
}


