package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GenreSelect {
    @GetMapping("/mvfetch/genre_selection")
    public String Genres() {
        return "mvfetch/genre_selection";
    }

    @GetMapping("/genre-select-api")
    @ResponseBody
    public String[] GenreSort(@RequestParam(name="GenresRaw", required=false, defaultValue="test,best,rest") String GenresRaw) {
        // GenresSorted will be used for later things, that's why we have redundant variable here.
        String[] GenresSorted = GenresRaw.split(",");
        int i;
        for (i = 0; i < GenresSorted.length; i++) {
            System.out.println(GenresSorted[i]);
        }
        return GenresSorted;
    }
}
