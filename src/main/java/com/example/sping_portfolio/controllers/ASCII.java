package com.example.sping_portfolio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ASCII {
    static String characterSet = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

    public String getArt() throws IOException {
        StringBuilder output = new StringBuilder();
        File f = new File("images/cat.jpg");
        BufferedImage img = ImageIO.read(f);

        int width = img.getWidth();
        int height = img.getHeight();

        int poolSize = 2;

        for (int y = 0; y < width; y += poolSize){
            for(int x=0; x < height; x += poolSize){
                int avgGrayLevel = 0;
                int cnt = 0;

                for(int xx = x; xx < x+poolSize; xx++) {
                    for(int yy = y; yy < y+poolSize; yy++) {
                        if(xx >= width || yy >= height) continue;

                        cnt++;

                        int rgb = img.getRGB(xx, yy);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = (rgb & 0xFF);

                        // Normalize and gamma correct:
                        float rr = (float) Math.pow(r / 255.0, 2.2);
                        float gg = (float) Math.pow(g / 255.0, 2.2);
                        float bb = (float) Math.pow(b / 255.0, 2.2);

                        // Calculate luminance:
                        float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                        // Gamma compand and rescale to byte range:
                        int grayLevel = (int) (70.0 * Math.pow(lum, 1.0 / 2.2));
                        avgGrayLevel += grayLevel;
                    }
                }

                avgGrayLevel /= (cnt == 0 ? 1 : cnt);
                output.append(characterSet.charAt(avgGrayLevel));
            }
            output.append("\n");
        }

        return output.toString();
    }

    @GetMapping("/ascii-api")
    @ResponseBody
    public String asciiAPI() throws IOException {
        return getArt();
    }
}
