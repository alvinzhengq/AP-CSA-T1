package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Greet {
    private static Map<String, String> ourBios = Map.of(
        "Alvin", "Lorem ipsum",
        "Akshay", "Hi! I'm Akshay and I'm a junior at Del Norte! My Interests include playing with computers, music, biking, and watching anime.",
        "Nolan", "Hi, I'm a junior at Del Norte High School and I am interested in CS, aerospace, and mathematics. I've been programming for almost six years and it's one of my biggest hobbies.",
        "Sami", "Lorem ipsum",
        "Prisha", "I'm a junior at Del Norte High School taking APCSA. I enjoy spending my free time hanging out with friends, listening to music, and playing video games."
    );

    @GetMapping("/greet")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           @RequestParam(name="data", required = false, defaultValue = "") String data,
                           Model model) {

        model.addAttribute("name", name);
        if(ourBios.containsKey(name)) {
            model.addAttribute("data", ourBios.get(name));
        } else {
            model.addAttribute("data", "No Bio Found.");
        }

        return "greet"; // returns HTML VIEW (greeting)
    }
}
