package com.example.sping_portfolio.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;


@Controller
public class Movies {
    private static ObjectMapper Json;

    @GetMapping("/mvfetch/movies")
    public String movies() {
        return "mvfetch/movies";
    }

    public JSONObject reqResult() throws Exception {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=ba188e9dabb5a98c2f73b97d834e220b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate&with_genres=16&with_genres=35";
        String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        JSONObject obj = new JSONObject(json);
        return obj;
    }

    public ArrayList<String> getTitles() throws Exception {
        ArrayList titles = new ArrayList<String>();
        JSONObject data = reqResult();

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            titles.add(movieDetails.get("original_title"));
        }

        return titles;
    }

    public ArrayList<String> getPosters() throws  Exception {
        ArrayList posters = new ArrayList<String>();
        JSONObject data = reqResult();

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            posters.add(movieDetails.get("original_title"));
        }

        return posters;
    }

    public static void main(String[] args) throws Exception {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=ba188e9dabb5a98c2f73b97d834e220b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate&with_genres=16&with_genres=35";
        String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        JSONObject obj = new JSONObject(json);
        ArrayList titles = new ArrayList<String>();
        ArrayList posterLinks = new ArrayList<String>();
        for (int i = 0; i < obj.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = obj.getJSONArray("results").getJSONObject(i);
            System.out.println("Movie Title" + movieDetails.get("original_title"));
            titles.add(movieDetails.get("original_title"));
            System.out.println("Cover URL: https://www.themoviedb.org/t/p/w100_and_h100_bestv2" + movieDetails.get("poster_path"));
            posterLinks.add("https://www.themoviedb.org/t/p/w100_and_h100_bestv2" + movieDetails.get("poster_path"));
        }
        System.out.println(titles);
        System.out.print(posterLinks);

    }
}
