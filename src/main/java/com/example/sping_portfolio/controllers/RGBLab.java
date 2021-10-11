package com.example.sping_portfolio.controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

class ImagePropertyRGB {
    public int[][][] rgbBinary;
    public int[][][] rgbDecimal;
    public String[][] rgbHex;

    public int width, height;

    public ImagePropertyRGB(BufferedImage img) {
        try{
            width = img.getWidth();
            height = img.getHeight();

            this.rgbBinary = new int[this.height][this.width][3];
            this.rgbDecimal = new int[this.height][this.width][3];
            this.rgbHex = new String[this.height][this.width];

            for (int y=0; y < this.height; y++){
                for(int x=0; x < this.width; x++){
                    int pixel = img.getRGB(x, y);
                    Color color = new Color(pixel, true);

                    this.rgbBinary[y][x][0] = this.rgbDecimal[y][x][0] = color.getRed();
                    this.rgbBinary[y][x][1] = this.rgbDecimal[y][x][1] = color.getGreen();
                    this.rgbBinary[y][x][2] = this.rgbDecimal[y][x][2] = color.getBlue();

                    this.rgbHex[y][x] =
                            Integer.toHexString(color.getRed()) +
                            Integer.toHexString(color.getGreen()) +
                            Integer.toHexString(color.getBlue())
                    ;
                }
            }

        } catch (Exception ignored) {}
    }
}

class ImageProperty {
    String base64Img;
    BufferedImage img;
    ImagePropertyRGB rgbProperties;

    int height, width;

    public ImageProperty(String fileUrl) {
        try {
            img = ImageIO.read(new URL(fileUrl));
        } catch (Exception ignore) {}
    }

    public void toBase64() {
    }
}

class ImageInfo {
    String imageFileUrl;
    ArrayList<ImageInfo> imgVariations;

    public ImageInfo() {}

    public void toGrayscale() {
    }

    public void addWatermark() {
    }
}
