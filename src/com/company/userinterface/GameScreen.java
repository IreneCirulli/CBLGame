package com.company.userinterface;

import com.company.objects.Land;
import com.company.objects.Obstacle;
import com.company.objects.Sky;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameScreen extends JPanel implements Runnable{

    private Thread thread;
    public int tickcount = 20;
    private Land land;
    private Sky sky;
    private Obstacle obstacle;
    private int i = 0;
    static boolean startgame = false;


    public GameScreen(){

        thread = new Thread(this);
        try {
            this.sky = new Sky();
            this.land = new Land();
            this.obstacle = new Obstacle();
        } catch (IOException e) {
        }

    }

    public void gameStart(){
        System.out.println(startgame);
        if(this.startgame == true){
            thread.start();
        }
    }

    public void paintComponent(Graphics g){
        sky.draw(g);
        land.draw(g);
        if(i>=300){
            obstacle.draw(g);
        }
    }

    @Override
    public void run(){
        while(true){
            try {
                i++;
                sky.updatelayer1();
                sky.updatelayer2();
                sky.updatelayer3();
                sky.updatelayer4();
                land.update();
                if(i>=500){
                    obstacle.update();
                }
                repaint();
                thread.sleep(tickcount);

            } catch (InterruptedException e) {
            }
        }
    }

}
