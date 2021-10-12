package com.example.sping_portfolio.minilabs.LoopMinilabs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrishaMiniLabs {

    @GetMapping("/PrishaMiniLabs")
    public String getPrishaMiniLabs() {
        return "PrishaMiniLabs";
    }
}


