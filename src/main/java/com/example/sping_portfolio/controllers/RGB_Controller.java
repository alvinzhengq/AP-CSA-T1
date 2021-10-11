package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RGB_Controller {
        @GetMapping("/RGB_Lab")
        public String getRGB_lab() {
            return "RGB_Lab";
        }
    }
