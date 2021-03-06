package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Binary {
    String imageOffPath = "/images/bulb_off.png";
    String imageOnPath = "/images/bulb_on.gif";

    @GetMapping("/binary")
    public String Binary(Model model, @RequestParam(name="bits", required=false, defaultValue="8") int bits) {
        model.addAttribute( "bits", bits);
        model.addAttribute("imageOffPath", imageOffPath);
        model.addAttribute("imageOnPath", imageOnPath);
        return "binary";
    }

}
