package com.company.userinterface;

import com.company.objects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements Runnable, KeyListener{

    private Thread thread;
    public int tickcount = 10;
    private Land land;
    private Sky sky;
    private Bunny bunny;
    private Obstacle obstacle;
    public int i = 0;
    private BunnyHitbox bunnyHitbox;
    private CollisionHandler collisionHandler;
    private Image gameoverImage;
    private Button restartButton;
    private double runcounter = 0.0;
    private JLabel runcounterLabel;
    private Font font;

    //private boolean startgame = false;
    static boolean startgame = false;
    private boolean gameOver = false;


    public GameScreen() {
        addKeyListener(this);
        setFocusable(true);
        thread = new Thread(this);
        try {
            this.sky = new Sky();
            this.land = new Land();
            this.bunny = new Bunny();
            this.bunnyHitbox = new BunnyHitbox();
            this.obstacle = new Obstacle();
            this.collisionHandler = new CollisionHandler(bunnyHitbox,obstacle.getObsticleList());
            this.gameoverImage =  ImageIO.read(new File("gameover2.png")).getScaledInstance(1000, 400, Image.SCALE_SMOOTH);;
        } catch (IOException e) {
        }

        this.runcounterLabel = new JLabel("meters ran = 0.0");
        this.font = new Font("Courier", Font.BOLD,20);
        runcounterLabel.setForeground(Color.white);
        Color backgroundcolour = new Color(174, 209, 187);
        runcounterLabel.setBackground(backgroundcolour);
        runcounterLabel.setOpaque(true);
        this.runcounterLabel.setFont(font);
        this.add(runcounterLabel, BorderLayout.NORTH);

    }

    /*public void setStartgame(boolean startgame) {
        this.startgame = startgame;
    }
     */

    public void gameStart(){
        //System.out.println(startgame);
        //while(this.startgame == true){
        System.out.println(startgame);
        if (this.startgame == true) {
            thread.start();
        }

        //}
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (!gameOver) {
            sky.draw(g);
            land.draw(g);
            bunny.draw(g);
            bunnyHitbox.draw(g);
            if (i>=200) {
                obstacle.draw(g);
            }
            Color rectcolour = new Color(138, 222, 169);
            g.setColor(rectcolour);
            g.fillRoundRect(350,3,300, 25, 20, 20);
        } else {
            this.remove(runcounterLabel);
            g.drawImage(gameoverImage, 0, 0, null);
        }
    }

    @Override
    public void run(){
        while(!gameOver){
            try {
                i++;
                if(i>=200){

                    String newruncounter = Integer.toString((i/10)-20);
                    runcounterLabel.setText("meters ran = " + newruncounter);
                }
                System.out.println(i);
                sky.updatelayer1();
                sky.updatelayer2();
                sky.updatelayer3();
                sky.updatelayer4();
                land.update();
                if (i>=200){
                    obstacle.update();
                }
                bunny.update(this.tickcount);
                bunnyHitbox.update(bunny.getY());
                collisionHandler.updateObsticles(obstacle.getObsticleList());
                this.gameOver = collisionHandler.checkCollision();
                repaint();

                thread.sleep(tickcount);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            //   System.out.println("Space key  pressed");
            bunny.setUpPressedValueTo(true);
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bunny.setDownPressedValueTo(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            bunny.setUpPressedValueTo(false);
        }  else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bunny.setDownPressedValueTo(false);
        }
        //  System.out.println("KEY RELEASED LOLLL");
    }

    public boolean gameOver() {
        return this.gameOver;
    }


}