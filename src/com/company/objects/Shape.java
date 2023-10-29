package com.company.objects;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

    public abstract void draw(Graphics g) ;

    public abstract void updatePosition(int x, int y);

    public abstract boolean checkCollision(Rectangle2 r);

    public abstract boolean checkCollision(Circle c);

    public abstract Point getCenter() ;


}
