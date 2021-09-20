package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class NolanRGBLab {
        @GetMapping("/NolanRGBLab/")
        public String team() {
            return "NolanRGBLab"; // returns HTML VIEW (greeting)
        }
    }


