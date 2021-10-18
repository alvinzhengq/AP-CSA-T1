package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Music {
    public String getToken() throws Exception {
        URLConnection connection = new URL("https://accounts.spotify.com/api/token").openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Basic NzVhOGQzOTU3NmMyNDRhYmIzYmM1OWJiY2VhZTNiNzY6MjgxOWQwMThkNmUxNGEwNGIyMTJjODQxOGI0YTBlZjI=");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");
        try (OutputStream output = connection.getOutputStream()) {
            output.write("grant_type=client_credentials".getBytes(StandardCharsets.UTF_8));
        }

        String output = "";
        InputStream response = connection.getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, StandardCharsets.UTF_8))) {
            output += reader.readLine();
        }

        JSONObject obj = new JSONObject(output);
        return obj.getString("access_token");
    }

    public String getLatestMusic(String token) throws Exception {
        URLConnection connection = new URL("https://api.spotify.com/v1/playlists/37i9dQZF1DX4JAvHpjipBk/tracks?offset=0&limit=12&additional_types=track%2Cepisode&market=US").openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        String output = "";
        InputStream response = connection.getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, StandardCharsets.UTF_8))) {
            output = reader.lines().collect(Collectors.joining());
        }

        return output;
    }

    @GetMapping("/mvfetch/music")
    public String getMusic() throws Exception {
        return "mvfetch/music";
    }

    @GetMapping("/mvfetch/music-api")
    @ResponseBody
    public String musicAPI() throws Exception {
        return getLatestMusic(getToken());
    }
}
