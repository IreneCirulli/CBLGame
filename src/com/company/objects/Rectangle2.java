package com.company.objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle2 extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    private int centerX;
    private int centerY;

    public Rectangle2(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.centerX = this.x + this.width/2;
        this.centerY = this.y + this.height/2;
    }

    public Rectangle2(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        this.centerX = this.x + this.width/2;
        this.centerY = this.y + this.height/2;
    }

    @Override
    public boolean checkCollision(Rectangle2 r) {
        return this.x <= r.getCords().x + r.getDimensions().width &&
                this.x + this.width >= r.getCords().x &&
                this.y <= r.getCords().y + r.getDimensions().height &&
                this.y + this.height >= r.getCords().y;
    }

    @Override
    public boolean checkCollision(Circle c) {
        int circleDistanceX = Math.abs(c.getCenter().x - this.x);
        int circleDistanceY = Math.abs(c.getCenter().y - this.y);

        if (circleDistanceX > (this.width/2 + c.getRadius())) {
            return false;
        }
        if (circleDistanceY > (this.height/2 + c.getRadius())) {
            return false;
        }
        if (circleDistanceX <= (this.width/2)) {
            return true;
        }
        if (circleDistanceY <= (this.height/2)) {
            return true;
        }
        int cornerDistanceSq =  (int) Math.pow((circleDistanceX - this.width/2),2) +
                (int) Math.pow((circleDistanceY - this.height/2), 2);

        return (cornerDistanceSq <= ( (int) Math.pow(c.getRadius(),2) ));

    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    public void updatePosition(int newx, int newy) {
        this.x = newx;
        this.y = newy;
        this.centerX = this.x + this.width / 2;
        this.centerY = this.y + this.height / 2;
    }

    public Point getCords() {
        return new Point(x,y);
    }

    @Override
    public Point getCenter() {
        return new Point(centerX, centerY);
    }

    public Dimension getDimensions() {
        return new Dimension(width, height);
    }

}

