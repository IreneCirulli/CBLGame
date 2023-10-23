package com.company.objects;

import java.awt.*;

public class ImageWPosX {

    private int xcooridnate;
    private Image image;
    private int num;

    public ImageWPosX(int xcooridnate, Image image) {
        this.xcooridnate = xcooridnate;
        this.image = image;
    }

    public ImageWPosX(int xcooridnate, Image image, int num) {
        this.xcooridnate = xcooridnate;
        this.image = image;
        this.num = num;
    }

    public int getXcooridnate() {
        return xcooridnate;
    }

    public Image getImage() {
        return image;
    }

    public void setXcooridnate(int xcooridnate) {
        this.xcooridnate = xcooridnate;
    }

    public void setImage(Image landimage) {
        this.image = image;
    }

    public int getNum() {
        return num;
    }

}
