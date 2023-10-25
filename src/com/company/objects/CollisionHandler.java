package com.company.objects;


import  java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CollisionHandler  {
    private BunnyHitbox bunnyHitbox;
    private ArrayList<Rectangle> obsticleList;

    public CollisionHandler(BunnyHitbox hitbox, ArrayList<Rectangle> obsticleList) {
        this.bunnyHitbox = hitbox;
        this.obsticleList = obsticleList;
    }

    public boolean checkCollision() {
        return this.bunnyHitbox.checkCollision(obsticleList);
    }
    public void updateObsticles(ArrayList<Rectangle> obsticleList) {
        this.obsticleList = obsticleList;
    }


}

