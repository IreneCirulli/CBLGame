package com.company.objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Circle extends Shape{
    private int x;
    private int y;
    private int r;

    public Circle(int cx, int cy, int r) {
        this.x = cx;
        this.y = cy;
        this.r = r;
    }

    public Circle(int r) {
        this.x = 0;
        this.y = 0;
        this.r = r;

    }

    @Override
    public boolean checkCollision(Rectangle2 r) {
        double circleDistanceX = Math.abs(this.x - r.getCenter().x);
        double circleDistanceY = Math.abs(this.y - r.getCenter().y);
        double distance =  Math.sqrt(Math.pow(circleDistanceX, 2) + Math.pow(circleDistanceY,2));

        double cornerDistanceSq =  (circleDistanceX - r.getDimensions().width/2.0)* (circleDistanceX - r.getDimensions().width/2.0) +
                (circleDistanceY - r.getDimensions().height/2.0) * (circleDistanceY - r.getDimensions().height/2.0);
        //System.out.println( (cornerDistanceSq <= this.r * this.r) + " | left : " + circleDistanceX + ", distance :  " + distance + " , r :  " + this.r + " , rect.width/2 = " + r.getDimensions().width/2.0  + " and r+w/2 is : " +( this.r + r.getDimensions().width/2.0) );

        if (circleDistanceX > (r.getDimensions().width/2.0 + this.r)) {

            return false;
        }
        if (circleDistanceY > (r.getDimensions().height/2.0 + this.r)) {
            return false;
        }
        if (circleDistanceX <= (r.getDimensions().width/2.0)) {
            System.out.println("dx");
            return true;
        }
        if (circleDistanceY <= (r.getDimensions().height/2.0)) {
            System.out.println("dy");
            return true;
        }
        // double cornerDistanceSq =  (circleDistanceX - r.getDimensions().width/2)* (circleDistanceX - r.getDimensions().width/2) +
        //                         (circleDistanceY - r.getDimensions().height/2) * (circleDistanceY - r.getDimensions().height/2);
        System.out.println(Math.sqrt(cornerDistanceSq));
        System.out.println(this.r );
        return /*false;*/ (cornerDistanceSq <= this.r * this.r);

        // Point leftBottomPoint = new Point(r.getCords().x + r.getDimensions().width,r.getCords().y + r.getDimensions().height);
        // Point rightBottomPoint = new Point(r.getCords().x, r.getCords().y + r.getDimensions().height);
        // if (leftBottomPoint.x < this.x) {
        //     System.out.println("left : " + circleDistanceX + " " + this.checkIfInside(leftBottomPoint));
        //     return this.checkIfInside(leftBottomPoint);
        // } else {
        //     System.out.println("not left");
        //     return (rightBottomPoint.x < this.x + this.r) && (rightBottomPoint.y < this.y + this.r);
        // }


        // int distance = (int) Math.sqrt((x - r.getCenter().x) *(x - r.getCenter().x) + (y - r.getCenter().y) * (y - r.getCenter().y));
        // boolean bool = distance <= this.r + r.getDimensions().width/2;

        // return  distance <= this.r + r.getDimensions().width/2;
    }

    @Override
    public boolean checkCollision(Circle c) {
        int distance =  (int) Math.sqrt(Math.pow(c.getCenter().x - this.x,2) + Math.pow(c.getCenter().y - this.y,2));

        return distance <= this.r + c.getRadius();
    }

    @Override
    public void draw(Graphics g) {
        int diameter = this.r * 2;
        g.drawOval(this.x - this.r, this.y - this.r, diameter, diameter);
    }

    @Override
    public void updatePosition(int newx, int newy) {
        this.x = newx;
        this.y = newy;
    }

    @Override
    public Point getCenter() {
        return new Point(x, y);
    }

    public int getRadius() {
        return this.r;
    }

    public boolean checkIfInside(Point p) {
        return (this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y) <= this.r * this.r;
    }




}

