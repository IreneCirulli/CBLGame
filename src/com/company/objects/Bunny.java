package com.company.objects;

import  java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Bunny {
    private Image sprite1;
    private Image sprite2;
    private Image sprite3;
    private static int LAND_LEVEL = 240;
    private ArrayList<Image> sprites;

    private int x  = 200;
    public int y = LAND_LEVEL;
    public int vel = 0;
    private  int acc = 0;
    private int maxAcc = 5;
    private int maxVel;


    private static int WIDTH = 75;
    private static int HEIGHT = 75;


    private boolean alternateImage = false;
    private int waitUntilNextImage = 0;
    public boolean hitboxIsVisible = true;
    private int k = 0;
    private int wait ;
    private int j = 1;//tickcount delay
    private int animationJ = 1;


    public boolean upPressed = false;
    public boolean downPressed = false;
    boolean ableToJump = true;
    private int firstJumpCounter = 0;
    private int jumps;
    private int maxJumps = 5;

    private boolean hasUpdate = true;

    private int counter = 0;


    public Bunny() {
        try {
            Image image1 = ImageIO.read(new File("bunny1.png"));
            this.sprite1 = image1.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

            Image image2 = ImageIO.read(new File("bunny2.png"));
            this.sprite2 = image2.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

            Image image3 = ImageIO.read(new File("bunny3.png"));
            this.sprite3 = image3.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);


            this.sprites = new ArrayList<Image>();
            this.sprites.add(this.sprite1);
            this.sprites.add(this.sprite2);
        } catch (IOException e) { }

    }

    public Image animation() {
        final int FRAMES_PER_SECOND = 10;


        if (this.y < LAND_LEVEL) {
            return this.sprite3;
        } else if (this.alternateImage) {
            this.waitUntilNextImage++;
            if (this.waitUntilNextImage == FRAMES_PER_SECOND - 3) {
                this.waitUntilNextImage = 0;
                this.alternateImage = false;
            }
            return this.sprite2;
        } else {
            this.waitUntilNextImage++;
            if (this.waitUntilNextImage == FRAMES_PER_SECOND) {
                this.waitUntilNextImage = 0;
                this.alternateImage = true;
            }
        }

        return this.sprite1;
    }

    public Image alternateAnimation() {
        final int FRAMES_PER_SECOND = 10;
        if (this.y < LAND_LEVEL) {
            return this.sprite3;
        }
        if (this.hasUpdate) {
            if (this.waitUntilNextImage == FRAMES_PER_SECOND) {
                this.alternateImage = true;
            }
            if (!this.alternateImage) {
                this.waitUntilNextImage++;
            } else {
                Image tempImage ;
                tempImage = this.sprites.get(0);
                this.sprites.remove(0);
                this.sprites.add(tempImage);
                this.alternateImage = false;
                this.waitUntilNextImage = 0;
            }
        }
        return this.sprites.get(0);
    }

    public void jump() {
        if (this.upPressed && ableToJump ) {
            if (determineFirstJump()) {
                this.vel = this.vel + 25;
            } else if (this.jumps < maxJumps) {
                this.vel = this.vel + 2;
            } else {
                this.ableToJump = false;
            }
            this.jumps++;
            this.acc = 1;
        } else {
            this.acc = 2;


        }
    }

    public void implementGravity() {
        // System.out.println("Entered gravity");
        if (this.y < LAND_LEVEL ) {
            if (this.vel < 0) {
                this.acc = 3;
            } else {
                this.acc = 5;
            }

        } else {
            this.acc = 0;
        }

    }

    public void makeDownKeyHappen() {
        if (downPressed && !upPressed ){
            System.out.println("down key pressed");
            if (this.vel > 0) {
                this.vel = 0;
            }
            this.vel-=7;
        }
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Point getCords(){
        return new Point(this.x, this.y);
    }

    public Dimension getDimension(){
        return new Dimension(this.WIDTH, this.HEIGHT);
    }

    public void updateHasUpdate(int n){
        this.wait =   20 /n;
        if (this.j == this.wait) {
            this.hasUpdate = true;
            this.j = 1;
        } else {
            this.hasUpdate = false;
            this.j ++;
        }
    }

    public boolean determineFirstJump() {
        if (this.firstJumpCounter < 1) {
            this.firstJumpCounter ++;
            //     System.out.println("First jump");
            return true;
        } else {
            //   System.out.println("Not First jump");
            return false;
        }
    }

    // public void countJumps() {
    //     if (this.jumps <= this.maxJumps) {
    //         this.jumps++;
    //     }
    // }

    public void resetValues() {
        this.ableToJump = true;
        this.firstJumpCounter = 0;
        this.vel = 0;
        this.acc = 0;
        this.jumps = 0;

    }

    public void updatePosition() {
        this.vel = this.vel - this.acc;
        this.y = this.y - this.vel;
        if (this.y >= LAND_LEVEL) {
            this.y = LAND_LEVEL;
        }
    }

    public void update(int n) {
        this.updateHasUpdate(n);
        if (true){
            if (this.y == LAND_LEVEL) {
                this.resetValues();
            }
            jump();
            makeDownKeyHappen();
            updatePosition();
        }

    }

    public void draw(Graphics g) {
        g.drawImage(alternateAnimation(), this.x, this.y, null);
        // Toolkit.getDefaultToolkit().sync();

    }

    public void drawHitbox(Graphics g) {


        if (this.hitboxIsVisible == true) {
            g.drawRect(this.x + 5, this.y + 30, WIDTH - 20, HEIGHT - 50);
        }

    }

    public void setUpPressedValueTo(boolean value) {
        this.upPressed = value;
    }

    public void setDownPressedValueTo(boolean value) {
        this.downPressed = value;
    }
}

