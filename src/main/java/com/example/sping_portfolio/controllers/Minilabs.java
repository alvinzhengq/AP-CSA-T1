package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;
import java.util.Map;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Minilabs {
    private static Map<String, Boolean> members = Map.of(
            "Alvin", true,
            "Akshay", true,
            "Nolan", true,
            "Sami", true,
            "Prisha", true
    );

    @GetMapping("/minilabs")
    public String getMinilabs() {
        return "minilabs"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/minilab-bio-api")
    public String greetingAPI(@RequestParam(name="name", required=false, defaultValue="nullBio") String name) {
        if(!members.containsKey(name)) {
            name = "nullBio";
        }
        return "fragments/bios :: " + name; // returns HTML VIEW (greeting)
    }

    @GetMapping("/minilab-quadform-api")
    @ResponseBody
    public String quadraticFormulaAPI(@RequestParam(name="a", required=false, defaultValue="0.0") double a,
                                      @RequestParam(name="b", required=false, defaultValue="0.0") double b,
                                      @RequestParam(name="c", required=false, defaultValue="0.0") double c) {
        double innerRad = b*b - 4*a*c;
        if(innerRad < 0) return "Imaginary Answer Unsupported";
        innerRad = Math.sqrt(innerRad);

        double x1 = (-b + innerRad)/2*a;
        double x2 = (-b - innerRad)/2*a;

        if(x1 == x2) {
            return "Answer: " + Double.toString(x1);
        } else {
            return "Answer: " + x1 + " and " + x2;
        }
    }
    @GetMapping("/minilab-string-api")
    @ResponseBody
    public String stringAPI(@RequestParam(name="stringLength", required=false, defaultValue="5") int stringLength) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String generatedString = "";
        for(int i = 0; i <= stringLength - 1; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(26);
            generatedString += alphabet.charAt(randomNumber);
        }
            return generatedString;
    }

    @GetMapping("/minilab-gcd-api")
    @ResponseBody
    public String gcdAPI(@RequestParam(name="a", required=false, defaultValue="1") int a,
                             @RequestParam(name="b", required=false, defaultValue="1") int b) {
        int guess = Integer.min(a,b);
        while((a%guess != 0 || b%guess != 0) && guess >= 1) {
            guess--;
        }

        return Integer.toString(guess);
    }
}
