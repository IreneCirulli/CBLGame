package com.company.objects;


import  java.awt.*;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import java.lang.Math;

public class Vector {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int length;

    private int vx;
    private int vy;

    public Vector(int x1,int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.vx = this.x2 - this.x1;
        this.vy = this.y2 - this.x1;
        this.length = (int) Math.round(Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2)));
    }

    public Vector(Point p1, Point p2) {
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;

        this.vx = this.x2 - this.x1;
        this.vy = this.y2 - this.x1;
        this.length = (int) Math.round(Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2)));

    }

    public Vector (int x, int y) {
        this.vx = x;
        this.vy = y;
        this.length = (int) Math.round(Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2)));
    }

    public void draw(Graphics g) {
        g.drawLine(x1,y1,x2,y2);
    }

    public Point getPoint1() {
        return new Point(x1, y1);
    }

    public Point getPoint2() {
        return new Point(x2, y2);
    }

    public int getLength() {
        return this.length;
    }

    public Point getVector() {
        return new Point(vx, vy);
    }

    public boolean checkCollision(Point p) {
        // Point p = new Point(r.getCords().x + r.getDimensions().width, r.getCords().y + r.getDimensions().height);
        Vector n =  this.getNormalVector();
        Vector vPoint = this.getVectorToPoint(p);
        int dotProduct = vPoint.calcDotProduct(n);
        return dotProduct > 0 ;
    }

    public int calcDotProduct(Vector v) {
        return (this.vx * v.getVector().x) + (this.vy * v.getVector().y);
    }

    public Vector getNormalVector() {
        return new Vector(- this.vy, this.vx);
    }

    /**
     * Creates a vector from the coords of the base of this vector to a new point.
     *
     * @param p the point
     * @return a vector from the base of the vector to the new point
     */
    public Vector getVectorToPoint(Point p) {
        return new Vector(x1, y1, p.x, p.y);
    }

}
