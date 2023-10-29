package com.company.objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BunnyHitbox  {

    private Bunny bunny;
    private Rectangle2 bunnyHitbox;
    private int hitboxX;
    private int hitboxY;
    private double hitboxYd;
    static int HITBOXWIDTH;
    static int HITBOXHEIGHT;

    private int centerX;
    private int centerY;



    public BunnyHitbox(){
        this.bunny = new Bunny();
        this.hitboxX = bunny.getX() + 5;
        this.hitboxY = bunny.getY() + 30;
        this.hitboxYd = this.hitboxY;
        BunnyHitbox.HITBOXWIDTH = bunny.getWidth() - 20;
        BunnyHitbox.HITBOXHEIGHT = bunny.getHeight() - 50;
        this.bunnyHitbox = new Rectangle2(hitboxX, hitboxY, HITBOXWIDTH, HITBOXHEIGHT);

        this.centerX = this.hitboxX + BunnyHitbox.HITBOXWIDTH/2;
        this.centerY = this.hitboxY + BunnyHitbox.HITBOXHEIGHT/2;


    }

    public void draw(Graphics g) {
        //g.drawRect(hitboxX,hitboxY,HITBOXWIDTH,HITBOXHEIGHT);
        bunnyHitbox.draw(g);

    }

    public void update(int bunnyPosition){
        this.hitboxY = bunnyPosition + 30;
        this.hitboxYd = this.hitboxY;
        // this.bunnyHitbox = new Rectangle(hitboxX , hitboxY, HITBOXWIDTH, HITBOXHEIGHT);
        this.bunnyHitbox.updatePosition(hitboxX, hitboxY);
        this.centerX = this.hitboxX + BunnyHitbox.HITBOXWIDTH/2;
        this.centerY = this.hitboxY + BunnyHitbox.HITBOXHEIGHT/2;

    }

    // public boolean intersectsWith(Rectangle secondHitbox) {
    //     return this.bunnyHitbox.intersects(secondHitbox);
    // }

    // public boolean checkCollision(ArrayList<Rectangle> listWithHitboxes) {
    //     // for (Rectangle rectangle : listWithHitboxes) {
    //     //     if (this.intersectsWith(rectangle)) {
    //     //         return true;
    //     //     }
    //     // }
    //     // return false;


    //     for (int i = 8; i < listWithHitboxes.size() - 1; i++) {
    //         if (this.intersectsWith(listWithHitboxes.get(i)) ) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public Rectangle2 getHitbox(){
        return bunnyHitbox;
    }

    public Point getcenterCords() {
        return new Point(centerX, centerY);
    }

    public double getYDouble() {
        return this.hitboxYd;
    }
    // public void drawDistanceFromCenters(Graphics g, Rectangle rectangle) {
    //     g.drawLine(centerX,centerY,rectangle.x + rectangle.width, rectangle.y + rectangle.height);

    // }
}
