package com.company.userinterface;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GameWindow extends JFrame{

    private GameScreen gscreen;
    static boolean startmusic = true;
    static Clip clip;
    static AudioInputStream ais;

    public GameWindow(){
        super("Bunny Game");
        setSize(1000, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            this.gscreen = new GameScreen();
        } catch (FileNotFoundException e) {
        }
        add(gscreen);
        File file = new File("bgmusic.wav");
        try {
            this.clip = AudioSystem.getClip();
            this.ais = AudioSystem.getAudioInputStream(file);
            music(clip, ais);
            } catch (UnsupportedAudioFileException e) {
            } catch (IOException e) {
            } catch (LineUnavailableException e) {
        }
        gscreen.gameStart();

    }

    public static void music(Clip clip, AudioInputStream ais) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        if(startmusic == true) {
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else{
            clip.stop();
            clip.close();
        }

    }
}

