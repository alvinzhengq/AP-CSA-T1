package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Greet {
    private static Map<String, Boolean> members = Map.of(
            "Alvin", true,
            "Akshay", true,
            "Nolan", true,
            "Sami", true,
            "Prisha", true
    );

    @GetMapping("/greet")
    public String greeting() {
        return "greet"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/greet-api")
    public String greetingAPI(@RequestParam(name="name", required=false, defaultValue="nullBio") String name) {
        if(!members.containsKey(name)) {
            name = "nullBio";
        }
        return "fragments/bios :: " + name; // returns HTML VIEW (greeting)
    }
}
