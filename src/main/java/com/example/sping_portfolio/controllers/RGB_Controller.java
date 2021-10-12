package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RGB_Controller {

        @GetMapping("/rgb-lab")
        public String getRGB_lab(Model model) {
            List<ImageInfo> imageInfoList = new ArrayList<>();

            String image0 = "http://localhost:8080/images/plant.jpg";
            ImageInfo if0 = new ImageInfo(image0); if0.getOriginalImg(); if0.getGrayscaleImg();
            imageInfoList.add(if0);

            String image1 = "http://localhost:8080/images/morning.jpg";
            ImageInfo if1 = new ImageInfo(image1); if1.getOriginalImg(); if1.getGrayscaleImg();
            imageInfoList.add(if1);

            model.addAttribute("iiList", imageInfoList);

            return "RGB_Lab";
        }
    }


