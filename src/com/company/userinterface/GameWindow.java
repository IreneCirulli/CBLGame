package com.company.userinterface;

import javax.swing.*;
import java.io.FileNotFoundException;

public class GameWindow extends JFrame{

    private GameScreen gscreen;

    public GameWindow(){
        super("Bunny Game");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            this.gscreen = new GameScreen();
        } catch (FileNotFoundException e) {
        }
        add(gscreen);
        gscreen.gameStart();

    }

}
