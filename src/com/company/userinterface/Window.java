package com.company.userinterface;

import javax.swing.*;

public class Window extends JFrame {

    private Screen screen;

    public Window(){
        super("CBL Game");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.screen = new Screen();
        add(screen);

    }

}
