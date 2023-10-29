package com.company.objects;


import  java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.company.objects.Vector;


public class CollisionHandler  {
    private BunnyHitbox bunnyHitbox;
    private ArrayList<Shape> obsticleList;
    //private Vector hitboxToObsticleLine;
    private int obsticleToCheck;


    public CollisionHandler(BunnyHitbox hitbox, ArrayList<Shape> obsticleList) {
        this.bunnyHitbox = hitbox;
        this.obsticleList = obsticleList;

    }

    // public boolean checkCollision(Rectangle2 r1, Rectangle2 r2) {
    //     return r1.getCords().x <= r2.getCords().x + r2.getDimensions().width &&
    //     r1.getCords().x + r1.getDimensions().width >= r2.getCords().x &&
    //     r1.getCords().y <= r2.getCords().y + r2.getDimensions().height &&
    //     r1.getCords().y + r1.getDimensions().height >= r2.getCords().y;
    // }

    // public boolean checkCollision(Circle c1, Circle c2) {
    //     int distance =  (int) Math.sqrt(Math.pow(c2.getCenter().x - c1.getCenter().x,2) + Math.pow(c2.getCenter().y - c1.getCenter().y,2));

    //     return distance <= c1.getRadius() + c2.getRadius();
    // }

    // public boolean checkCollision(Rectangle2 r, Circle c) {
    //     int circleDistanceX = Math.abs(c.getCenter().x - r.getCenter().x);
    //     int circleDistanceY = Math.abs(c.getCenter().y - r.getCenter().y);

    //     if (circleDistanceX > (r.getDimensions().width/2 + c.getRadius())) {
    //         return false;
    //     }
    //     if (circleDistanceY > (r.getDimensions().height/2 + c.getRadius())) {
    //         return false;
    //     }
    //     if (circleDistanceX <= (r.getDimensions().width/2)) {
    //         return true;
    //     }
    //     if (circleDistanceY <= (r.getDimensions().height/2)) {
    //         return true;
    //     }
    //     int cornerDistanceSq =  (int) Math.pow((circleDistanceX - r.getDimensions().width/2),2) +
    //                             (int) Math.pow((circleDistanceY - r.getDimensions().height/2), 2);

    //     return (cornerDistanceSq <= ( (int) Math.pow(c.getRadius(),2) ));

    // }

    public boolean hitDecection() {
        // ArrayList<Integer> distances = new ArrayList<Integer>();
        // int minIndex = 0;

        for (int i = 8 ; i < obsticleList.size(); i++) {
            // distances.add(calcDistance(obsticleList.get(i)));
            // int minDistance = Collections.min(distances);
            // minIndex = distances.indexOf(minDistance);

            if (obsticleList.get(i).checkCollision(bunnyHitbox.getHitbox())) {
                return true;
            }
        }
        //this.obsticleToCheck = minIndex;
        // return obsticleList.get(minIndex).checkCollision(bunnyHitbox.getHitbox());

        return false;
    }

    public void updateObsticles(ArrayList<Shape> obsticleList) {
        this.obsticleList = obsticleList;
    }

    // public void drawDistanceFromCenters(Graphics g) {

    //     g.drawLine(bunnyHitbox.getcenterCords().x,bunnyHitbox.getcenterCords().y,obsticleList.get(obsticleToCheck).getCenter().x, obsticleList.get(obsticleToCheck).getCenter().y);
    // }

    // public void findClosestObstacle() {
    //     int[] distances = new int[obsticleList.size() + 8];


    //     for (int i = 8; i < obsticleList.size(); i++) {
    //         distances[i + 8] =
    //     }
    // }

    // public void drawDistances(Graphics g) {
    //     for (int i = 8; i < obsticleList.size(); i++) {
    //         drawDistanceFromCenters(g, obsticleList.get(i));
    //     }
    // }

    /**
     * Calc distance between the center of the hitbox and a obsticle
     *
     * @param shape an osbticle
     * @return distance as an in
     */
    public int calcDistance(Shape shape) {
        int cx = shape.getCenter().x;
        int cy = shape.getCenter().y;
        int rx = this.bunnyHitbox.getHitbox().getCenter().x;
        int ry = this.bunnyHitbox.getHitbox().getCenter().y;




        return (int) Math.sqrt(Math.pow(cx-rx,2) + Math.pow(cy-ry,2));

    }
}


