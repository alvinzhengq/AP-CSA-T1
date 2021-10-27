package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreSelect {
    @GetMapping("/mvfetch/genre_selection")
    public String Genres() {
        return "mvfetch/genre_selection";
    }

    @PostMapping(value = "/genre-select-api", consumes = "text/plain")
    @ResponseBody
    public void GenreSort(@RequestBody String GenresRaw) {
        System.out.println(GenresRaw);
    }
}
