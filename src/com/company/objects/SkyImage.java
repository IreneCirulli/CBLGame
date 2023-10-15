package com.company.objects;

import java.awt.*;

public class SkyImage {

    public int xcooridnate;
    private Image skyimage;

    public SkyImage(int xcooridnate, Image skyimage) {
        this.xcooridnate = xcooridnate;
        this.skyimage = skyimage;
    }

    public int getXcooridnate() {
        return xcooridnate;
    }

    public Image getSkyimage() {
        return skyimage;
    }

    public void setXcooridnate(int xcooridnate) {
        this.xcooridnate = xcooridnate;
    }

    public void setSkyimage(Image skyimage) {
        this.skyimage = skyimage;
    }

}
