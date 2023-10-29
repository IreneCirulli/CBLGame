package com.company.objects;

import java.awt.Graphics;
import java.awt.Point;
import com.company.objects.Vector;

public class Triangle extends Shape{
    private Vector vector1;
    private Vector vector2;
    private Vector vector3;

    /**
     * left points of a triangle.
     */
    private Point p1;

    /**
     * right points of a triangle.
     */
    private Point p2;

    /**
     * top point of a triangle.
     */
    private Point p3;

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    private int cx;
    private int cy;
    private int height;
    private int base;

    private Point test ;


    private Triangle(int cx, int cy, int height, int base) {
        this.cx = cx;
        this.cy = cy;
        this.height = height;
        this.base = base;


        this.p1 = new Point(cx - base/2, cy + height/2);

        this.p2 = new Point(cx + base/2, cy + height/2);

        this.p3 = new Point(cx, cy - height/2);

        this.vector1 = new Vector(p1, p3);
        this.vector2 = new Vector(p3,p2);
        this.vector3 = new Vector(p2,p1);

    }

    public  Triangle( int height, int base) {
        this.cx = 0;
        this.cy = 0;
        this.height = height;
        this.base = base;

        this.p1 = new Point(cx - base/2, cy + height/2);

        this.p2 = new Point(cx + base/2, cy + height/2);

        this.p3 = new Point(cx, cy - height/2);
        this.vector1 = new Vector(p1, p3);
        this.vector2 = new Vector(p3, p2);
        this.vector3 = new Vector(p2, p1);

    }

    @Override
    public void draw(Graphics g) {
        g.drawPolygon(new int[] {p1.x, p2.x, p3.x}, new int[] {p1.y, p2.y, p3.y}, 3);
        // vector1.getVectorToPoint(test).draw(g);
        // vector2.getVectorToPoint(test).draw(g);
        // vector3.getVectorToPoint(test).draw(g);

    }

    @Override
    public void updatePosition(int x, int y) {
        this.cx = x;
        this.cy = y;

        this.p1 = new Point(cx - base/2, cy + height/2);

        this.p2 = new Point(cx + base/2, cy + height/2);

        this.p3 = new Point(cx, cy - height/2);

        this.vector1 = new Vector(p1, p3);
        this.vector2 = new Vector(p3,p2);
        this.vector3 = new Vector(p2,p1);
    }

    @Override
    public boolean checkCollision(Rectangle2 r) {
        // this.test = new Point(r.getCords().x + r.getDimensions().width, r.getCords().y + r.getDimensions().height);
        Point rightPoint = new Point(r.getCords().x + r.getDimensions().width, r.getCords().y + r.getDimensions().height);
        if (rightPoint.x <= this.cx) {
            //  System.out.println("right");
            return vector1.checkCollision(rightPoint) && vector2.checkCollision(rightPoint) &&  vector3.checkCollision(rightPoint);
        } else {
            //  System.out.println("left");
            Point leftPoint = new Point(r.getCords().x , r.getCords().y + r.getDimensions().height);
            return vector1.checkCollision(leftPoint) && vector2.checkCollision(leftPoint) &&  vector3.checkCollision(leftPoint);
        }

        // return vector1.checkCollision(r) && vector2.checkCollision(r) &&  vector3.checkCollision(r);
    }

    @Override
    public boolean checkCollision(Circle c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkCollision'");
    }

    @Override
    public Point getCenter() {
        return new Point(cx, cy);
    }
}

