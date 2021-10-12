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
    ArrayList<Object> imgVariations;
    ImageProperty imgProperties;
    BufferedImage img;
    public ImageInfo(String imageFileUrl) {
        try {
            this.imageFileUrl = imageFileUrl;
            this.img = ImageIO.read(new URL(imageFileUrl));
            this.imgProperties = new ImageProperty(img);
        } catch (Exception ignore) {}
    }

    public void toGrayscale() {
        try {
         //   BufferedImage img = ImageIO.read(new URL(imageFileUrl));
            ImageProperty ip = new ImageProperty(img);
            byte[] pixels = ip.image_to_pixels(img);
            String base64Original = toBase64(pixels);


            byte[] grayedPixels = pixelGrayScale(pixels);
            String base64Grayed = toBase64(grayedPixels);

            // General Link
            imgVariations.add(imageFileUrl);

            // Original Image (No GrayScale):
            imgVariations.add(ip);
            imgVariations.add(ip.toBase64());
            imgVariations.add(ip.image_to_pixels(img));
            imgVariations.add("data:image/jpg;base64,"+base64Original);

            // Altered Image (Grayed):
            imgVariations.add(base64Grayed);
            imgVariations.add(grayedPixels);
            imgVariations.add("data:image/jpg;base64,"+base64Grayed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] pixelGrayScale(byte[] pixelsIn){
        byte[] newPixelsByte = new byte[pixelsIn.length];
        for(int i=0;i<pixelsIn.length;i+=4) {
            float val = 0;
            for(int y=1;y<4;y++) {
                val += (pixelsIn[i+y] & 0xFF)/3.0;
            }
            newPixelsByte[i] = pixelsIn[i];
            newPixelsByte[i+1] = (byte)val;
            newPixelsByte[i+2] = (byte)val;
            newPixelsByte[i+3] = (byte)val;
        }
        return newPixelsByte;
    }
    public String toBase64(byte[] pixels) {
        try {
            return Base64.encodeBase64String(pixels);
        } catch (Exception ignored) {}
        return "";
    }

    public ArrayList<Object> getImgVariations() {
        return imgVariations;
    }



    public void addWatermark() {
    }
}
