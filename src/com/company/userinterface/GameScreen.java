package com.company.userinterface;

import com.company.objects.Land;
import com.company.objects.Sky;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameScreen extends JPanel implements Runnable{

    private Thread thread;
    public int tickcount = 20;
    private Land land;
    private Sky sky;
    private int i = 0;
    //private boolean startgame = false;


    public GameScreen(){

        thread = new Thread(this);
        try {
            this.sky = new Sky();
            this.land = new Land();
        } catch (IOException e) {
        }

    }

    /*public void setStartgame(boolean startgame) {
        this.startgame = startgame;
    }
     */

    public void gameStart(){
        //System.out.println(startgame);
        //while(this.startgame == true){
            thread.start();
        //}
    }

    public void paint(Graphics g){
        sky.draw(g);
        land.draw(g);
    }

    @Override
    public void run(){
        while(true){
            try {
                i++;
                sky.update();
                land.update();
                repaint();
                thread.sleep(tickcount);

            } catch (InterruptedException e) {
            }
        }
    }

}
