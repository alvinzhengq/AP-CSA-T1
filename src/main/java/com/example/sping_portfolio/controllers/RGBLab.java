package com.example.sping_portfolio.controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.util.Base64;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class ImagePropertyRGB {
    public int[][][] rgbBinary;
    public int[][][] rgbDecimal;
    public String[][] rgbHex;

    public int width, height;

    public ImagePropertyRGB(BufferedImage img) {
        try{
            width = img.getWidth()/10;
            height = img.getHeight()/10;

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
    public String base64Img;
    public BufferedImage img;
    public ImagePropertyRGB rgbProperties;

    public int height, width;

    public ImageProperty(BufferedImage _img) {
        try {
            img = _img;
            rgbProperties = new ImagePropertyRGB(img);
            width = img.getWidth();
            height = img.getHeight();

            base64Img = toBase64();
        } catch (Exception ignore) {}
    }

    public byte[] imageToPixels() throws IOException {
        return ((DataBufferByte) this.img.getRaster().getDataBuffer()).getData();
    }

    public String toBase64() {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            OutputStream b64 = Base64.getEncoder().wrap(os);
            ImageIO.write(img, "png", b64);

            return os.toString("UTF-8");
        } catch (Exception ignored) {}
        return "";
    }
}

class ImageInfo {
    public String imageFileUrl;
    public List<ImageProperty> imgVariationList;

    public ImageInfo(String imageFileUrl) {
        try {
            this.imageFileUrl = imageFileUrl;
            this.imgVariationList = new ArrayList<>();
        } catch (Exception ignore) {}
    }

    public void getOriginalImg() {
        try {
            imgVariationList.add(new ImageProperty(ImageIO.read(new URL(this.imageFileUrl))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getGrayscaleImg() {
        try {
            BufferedImage img = ImageIO.read(new URL(this.imageFileUrl));
            for (int x = 0; x < img.getWidth(); ++x){
                for (int y = 0; y < img.getHeight(); ++y)
                {
                    int rgb = img.getRGB(x, y);
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
                    int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                    int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                    img.setRGB(x, y, gray);
                }
            }

            imgVariationList.add(new ImageProperty(img));
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

    public List<ImageProperty> getImgVariations() {
        return imgVariationList;
    }
}
