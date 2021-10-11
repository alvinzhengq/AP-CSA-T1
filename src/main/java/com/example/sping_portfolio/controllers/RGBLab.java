package com.example.sping_portfolio.controllers;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringJoiner;

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

    public ImageProperty(BufferedImage _img) {
        try {
            img = _img;
            rgbProperties = new ImagePropertyRGB(img);
            base64Img = toBase64();
        } catch (Exception ignore) {}
    }

    public byte[] image_to_pixels(BufferedImage img) throws IOException {
        return ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    }

    public String toBase64() {
        try {
            width = img.getWidth();
            height = img.getHeight();
            byte[] pixels = image_to_pixels(img);

            return Base64.encodeBase64String(pixels);
        } catch (Exception ignored) {}
        return "";
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
