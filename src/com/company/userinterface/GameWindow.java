package com.company.userinterface;

import javax.swing.*;

public class GameWindow extends JFrame{

    private GameScreen gscreen;

    public GameWindow(){
        super("Bunny Game");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gscreen = new GameScreen();
        add(gscreen);
        gscreen.gameStart();
    }

}
