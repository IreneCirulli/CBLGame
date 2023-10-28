package com.company.userinterface;

import com.company.objects.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

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
    private JButton restartButton;
    private JLabel runcounterLabel;
    private Font font;
    private String runnercounterString;
    private String personalrecordString;

    static boolean startgame = false;
    private boolean gameOver = false;


    public GameScreen() throws FileNotFoundException {
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
        } catch (IOException e) {
        }

        this.runcounterLabel = new JLabel("meters ran = 0.0");
        this.font = new Font("Courier", Font.BOLD,17);
        runcounterLabel.setForeground(Color.white);
        Color backgroundcolour = new Color(138, 222, 169);
        runcounterLabel.setBackground(backgroundcolour);
        runcounterLabel.setOpaque(true);
        this.runcounterLabel.setFont(font);
        this.add(runcounterLabel, BorderLayout.NORTH);
        this.runnercounterString = " ";
        Scanner scanner = new Scanner(new File("personalrecord.txt"));
        while (scanner.hasNextLine() == true) {
            this.personalrecordString = scanner.nextLine();
        }
        scanner.close();
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
            if (i>=600) {
                obstacle.draw(g);
            }
            Color rectcolour = new Color(138, 222, 169);
            g.setColor(rectcolour);
            g.fillRoundRect(220,3,550, 25, 20, 20);
        } else {
            thread.interrupt();
            GameWindow.startmusic = false;
            try {
                GameWindow.music(GameWindow.clip, GameWindow.ais);
            } catch (LineUnavailableException e) {
            } catch (IOException e) {
            } catch (UnsupportedAudioFileException e) {
            }
            try {
                this.gameoverImage =  ImageIO.read(new File("gameover2.png")).getScaledInstance(1000, 380, Image.SCALE_SMOOTH);
            } catch (IOException e) {
            }
            g.drawImage(gameoverImage, 0, 0, null);
            this.restartButton = new JButton("RESTART GAME");
            endGame();
        }
    }

    public void endGame(){

        if(Integer.parseInt(runnercounterString) >= Integer.parseInt(personalrecordString)){
            clearFile();
            try {
                addtoFile(runnercounterString);
            } catch (IOException e) {
            }
        }
        this.remove(runcounterLabel);
        setLayout(new BorderLayout());
        add(restartButton, BorderLayout.CENTER);
        GameWindow.startmusic = true;
        restartButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        });
    }

    public void clearFile(){
        try{
            FileWriter fw = new FileWriter("personalrecord.txt", false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }catch(Exception exception){
        }
    }

    public void addtoFile(String newrecord) throws IOException {

        FileWriter filew = new FileWriter("personalrecord.txt", true);
        BufferedWriter bw = new BufferedWriter(filew);
        PrintWriter fw = new PrintWriter(bw);

        fw.println(newrecord);
        fw.close();

    }

    @Override
    public void run(){
        while(!gameOver){
            try {
                i++;
                if(i>=400){
                    runnercounterString = Integer.toString((i/10)-20);
                    runcounterLabel.setText("personal record = " + personalrecordString + " meters currently ran = " + runnercounterString);
                }
                System.out.println(i);
                sky.updatelayer1();
                sky.updatelayer2();
                sky.updatelayer3();
                sky.updatelayer4();
                land.update();
                if (i>=600){
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