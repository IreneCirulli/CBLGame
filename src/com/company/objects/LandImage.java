package com.company.objects;

import java.awt.*;

public class LandImage {

    public int xcooridnate;
    private Image landimage;

    public LandImage(int xcooridnate, Image landimage) {
        this.xcooridnate = xcooridnate;
        this.landimage = landimage;
    }

    public int getXcooridnate() {
        return xcooridnate;
    }

    public Image getLandimage() {
        return landimage;
    }

    public void setXcooridnate(int xcooridnate) {
        this.xcooridnate = xcooridnate;
    }

    public void setLandimage(Image landimage) {
        this.landimage = landimage;
    }
}
