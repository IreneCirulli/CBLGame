package com.company.userinterface;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    private JButton startbutton;
    private GameWindow gwindow;

    public Screen(){

        setBackground(Color.BLUE);
        this.startbutton = new JButton("GAME START");
        startbutton.setSize(400, 100);
        this.add(startbutton, BorderLayout.CENTER);

        this.gwindow = new GameWindow();
        gwindow.setSize(1000, 400);

        startbutton.addActionListener(e -> {
            gwindow.setVisible(true);
        });

    }


}
