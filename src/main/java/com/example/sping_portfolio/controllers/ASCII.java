package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Controller
public class ASCII {
    @GetMapping("/ascii")
    public String ascii() {
        return  "ascii";
    }

    static String characterSet = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

    public static String getArt(String urlForFile) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedImage img = ImageIO.read(new URL(urlForFile));

        int width = img.getWidth();
        int height = img.getHeight();

        int poolSize = 2;

        for (int y = 0; y < height; y += poolSize){
            for(int x=0; x < width; x += poolSize){
                double avgGrayLevel = 0;
                double cnt = 0;

                for(int xx = x; xx < x+poolSize; xx++) {
                    for(int yy = y; yy < y+poolSize; yy++) {
                        if(xx >= width || yy >= height) continue;

                        cnt++;

                        float avgColor = 0;
                        int color = img.getRGB(xx, yy);

                        avgColor += ((color >> 16) & 0xFF);
                        avgColor += ((color >> 8) & 0xFF);
                        avgColor += (color & 0xFF);

                        avgGrayLevel += (double)(avgColor/3.0);
                    }
                }

                avgGrayLevel /= (cnt == 0.0 ? 1.0 : cnt);
                avgGrayLevel = (69) * ((avgGrayLevel - 0) / (255)) + 0;
                output.append(characterSet.charAt((int) Math.floor(avgGrayLevel))).append("  ");
            }
            output.append("\n");
        }

        return output.toString();
    }

    @GetMapping("/ascii-api")
    @ResponseBody
    public String asciiAPI(HttpServletRequest req) throws IOException {
//        return getArt(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/download.jfif");
        return getArt(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/images/cat.png");
//        return getArt("https://wallpaperaccess.com/full/526285.jpg");

    }
}
