package com.example.sping_portfolio.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Movies {
    private static ObjectMapper Json;

    @GetMapping("/mvfetch/movies")
    public String movies() {
        return "mvfetch/movies";
    }

    @GetMapping("/mvfetch/movies-api")
    @ResponseBody
    public String[] movieAPI() throws Exception {
        ArrayList<String> titles = getTitles();

        String[] titlesArray = new String[titles.size()];
        titlesArray = titles.toArray(titlesArray);

        return titlesArray;
    }

    @GetMapping("/mvfetch/movies-titles-api")
    @ResponseBody
    public String[] movieTitleAPI() throws Exception {
        ArrayList<String> posters = getPosters();

        String[] postersArray = new String[posters.size()];
        postersArray = posters.toArray(postersArray);

        return postersArray;
    }


    public JSONObject reqResult() throws Exception {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=ba188e9dabb5a98c2f73b97d834e220b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate&with_genres=16&with_genres=35";
        String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        return new JSONObject(json);
    }

    public ArrayList<String> getTitles() throws Exception {
        ArrayList<String> titles = new ArrayList<String>();
        JSONObject data = reqResult();

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            titles.add(movieDetails.get("original_title").toString());
        }

        return titles;
    }

    public ArrayList<String> getPosters() throws  Exception {
        ArrayList<String> posters = new ArrayList<String>();
        JSONObject data = reqResult();

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            posters.add(movieDetails.get("original_title").toString());
        }

        return posters;
    }
}
