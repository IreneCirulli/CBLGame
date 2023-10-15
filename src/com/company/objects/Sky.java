package com.company.objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Sky {

    private Image sky1;
    private Image sky2;
    private Image sky3;
    private Image sky4;
    private ArrayList<SkyImage> listSkyImage;
    private int counter = 1;

    public Sky() throws IOException {

        BufferedImage bufferedsky1pic = null;
        BufferedImage bufferedsky2pic = null;
        BufferedImage bufferedsky3pic = null;
        BufferedImage bufferedsky4pic = null;
        try {
            bufferedsky1pic = ImageIO.read(new File("sky1.png"));
            bufferedsky2pic = ImageIO.read(new File("sky2.png"));
            bufferedsky3pic = ImageIO.read(new File("sky3.png"));
            bufferedsky4pic = ImageIO.read(new File("sky4.png"));
        } catch (IOException e) {
        }
        Image sky1pic = bufferedsky1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image sky2pic = bufferedsky2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image sky3pic = bufferedsky3pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image sky4pic = bufferedsky4pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        this.sky1 = sky1pic;
        this.sky2 = sky2pic;
        this.sky3 = sky3pic;
        this.sky4 = sky4pic;

        listSkyImage = new ArrayList<SkyImage>();
        for(int i = 0; i < 8; i++){
            int posx = 300*i;
            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                SkyImage iSky = new SkyImage(posx, sky1);
                listSkyImage.add(iSky);
            } else if(randomnum == 1){
                SkyImage iSky = new SkyImage(posx, sky2);
                listSkyImage.add(iSky);
            } else if(randomnum == 2){
                SkyImage iSky = new SkyImage(posx, sky3);
                listSkyImage.add(iSky);
            } else if(randomnum == 3){
                SkyImage iSky = new SkyImage(posx, sky4);
                listSkyImage.add(iSky);
            }
        }
    }

    public void update(){
        for(SkyImage iSky: listSkyImage){
            iSky.setXcooridnate((iSky.getXcooridnate()-1));
        }
        if(listSkyImage.get(counter).getXcooridnate() == 0){
            SkyImage end = listSkyImage.get(listSkyImage.size()-1);
            Image skyimage = sky1;
            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                skyimage = sky1;
            } else if(randomnum == 1){
                skyimage = sky2;
            } else if(randomnum == 2){
                skyimage = sky3;
            } else if(randomnum == 3){
                skyimage = sky4;
            }
            SkyImage newaddition = new SkyImage((end.getXcooridnate()+300), skyimage);
            listSkyImage.add(newaddition);
            counter++;
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < listSkyImage.size()-2; i++){
            g.drawImage(listSkyImage.get(i).getSkyimage(), listSkyImage.get(i).getXcooridnate(), 0, null);
        }
    }

}
