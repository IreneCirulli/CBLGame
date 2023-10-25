package com.company.objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BunnyHitbox  {

    private Bunny bunny;
    private Rectangle bunnyHitbox;
    private int hitboxX;
    private int hitboxY;
    static int HITBOXWIDTH;
    static int HITBOXHEIGHT;



    public BunnyHitbox(){
        this.bunny = new Bunny();
        this.hitboxX = bunny.getX() + 5;
        this.hitboxY = bunny.getY() + 30;
        BunnyHitbox.HITBOXWIDTH = bunny.getWidth() - 20;
        BunnyHitbox.HITBOXHEIGHT = bunny.getHeight() - 50;
        this.bunnyHitbox = new Rectangle(hitboxX , hitboxY, HITBOXWIDTH, HITBOXHEIGHT);
    }

    public void draw(Graphics g) {
        g.drawRect(hitboxX,hitboxY,HITBOXWIDTH,HITBOXHEIGHT);

    }

    public void update(int bunnyPosition){
        this.hitboxY = bunnyPosition + 30;
        this.bunnyHitbox = new Rectangle(hitboxX , hitboxY, HITBOXWIDTH, HITBOXHEIGHT);
    }

    public boolean intersectsWith(Rectangle secondHitbox) {
        return this.bunnyHitbox.intersects(secondHitbox);
    }

    public boolean checkCollision(ArrayList<Rectangle> listWithHitboxes) {
        // for (Rectangle rectangle : listWithHitboxes) {
        //     if (this.intersectsWith(rectangle)) {
        //         return true;
        //     }
        // }
        // return false;

        for (int i = 8; i < listWithHitboxes.size() - 1; i++) {
            if (this.intersectsWith(listWithHitboxes.get(i)) ) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getHitbox(){
        return bunnyHitbox;
    }

}
