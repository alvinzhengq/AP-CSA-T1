package com.example.sping_portfolio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URL;
import java.util.*;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Movies {
    private static ObjectMapper Json;
    class Movie {
        String title;
        String overview;
        String rating;
        String releaseDate;
        public Movie(String title, String overview, String rating, String releaseDate) {
        this.title = title;
        this.overview = overview;
        this.rating = rating;
        this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }
        public String getOverview() {
            return overview;
        }
        public String getRating() {
            return rating;
        }
        public String getReleaseDate() {
            return releaseDate;
        }
    }

    @GetMapping("/mvfetch/movies")
    public String movies() {
        return "mvfetch/movies";
    }

    @PostMapping(value = "/mvfetch/movies-api", consumes = "text/plain")
    @ResponseBody
    public String[] movieAPI(@RequestBody String genresToFilter) throws Exception {
        ArrayList<String> moviesList = getTitles(genresToFilter);

        String[] moviesArray = new String[moviesList.size()];
        moviesArray = moviesList.toArray(moviesArray);


        return moviesArray;
    }

    @GetMapping("/mvfetch/movies-titles-api")
    @ResponseBody
    public String[] movieTitleAPI(String genresToFilter) throws Exception {
        ArrayList<String> posters = getPosters(genresToFilter);

        String[] postersArray = new String[posters.size()];
        postersArray = posters.toArray(postersArray);

        return postersArray;
    }

    public JSONObject reqResult(String genresToFilter) throws Exception {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=ba188e9dabb5a98c2f73b97d834e220b&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate" + genresToFilter;
        String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        return new JSONObject(json);
    }

    public ArrayList<String> getTitles(String genresToFilter) throws Exception {
        ArrayList<String> movies = new ArrayList<>();

        JSONObject data = reqResult(genresToFilter);

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            Movie movie = new Movie(movieDetails.get("original_title").toString(), movieDetails.get("overview").toString(), movieDetails.get("vote_average").toString(), movieDetails.get("release_date").toString());
            movies.add(i, movie.getTitle() + "$$$" + movie.getOverview() + "$$$" + movie.getRating() + "$$$" + movie.getReleaseDate());
        }

        return movies;
    }

    public ArrayList<String> getOverviews(String genresToFilter) throws Exception {
        ArrayList<String> overviews = new ArrayList<String>();
        JSONObject data = reqResult(genresToFilter);

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            overviews.add(movieDetails.get("overview").toString());
        }

        return overviews;
    }

    public ArrayList<String> getPosters(String genresToFilter) throws  Exception {
        ArrayList<String> posters = new ArrayList<String>();
        JSONObject data = reqResult(genresToFilter);

        for (int i = 0; i<data.getJSONArray("results").length(); i++) {
            JSONObject movieDetails = data.getJSONArray("results").getJSONObject(i);
            posters.add(movieDetails.get("original_title").toString());
        }

        return posters;
    }
}