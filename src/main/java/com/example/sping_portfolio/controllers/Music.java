package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Music {
    @GetMapping("/mvfetch/music")
    public String music() {
        return "mvfetch/music";
    }
}
