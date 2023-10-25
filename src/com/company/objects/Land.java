package com.company.objects;

import com.company.userinterface.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Land {

    private Image land1;
    private Image land2;
    private Image land3;
    private Image land4;
    private ArrayList<ImageWPosX> listLandImage;
    private int counter = 1;
    private int i = 0;

    public Land() throws IOException {

        BufferedImage bufferedland1pic = null;
        BufferedImage bufferedland2pic = null;
        BufferedImage bufferedland3pic = null;
        BufferedImage bufferedland4pic = null;
        try {
            bufferedland1pic = ImageIO.read(new File("land1.png"));
            bufferedland2pic = ImageIO.read(new File("land2.png"));
            bufferedland3pic = ImageIO.read(new File("land3.png"));
            bufferedland4pic = ImageIO.read(new File("land4.png"));
        } catch (IOException e) {
        }
        Image land1pic = bufferedland1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image land2pic = bufferedland2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image land3pic = bufferedland3pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        Image land4pic = bufferedland4pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

        this.land1 = land1pic;
        this.land2 = land2pic;
        this.land3 = land3pic;
        this.land4 = land4pic;

        listLandImage = new ArrayList<ImageWPosX>();
        for(int i = 0; i < 11; i++){
            int posx = 300*i;
            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                ImageWPosX iLand = new ImageWPosX(posx, land1);
                listLandImage.add(iLand);
            } else if(randomnum == 1){
                ImageWPosX iLand = new ImageWPosX(posx, land2);
                listLandImage.add(iLand);
            } else if(randomnum == 2){
                ImageWPosX iLand = new ImageWPosX(posx, land3);
                listLandImage.add(iLand);
            } else if(randomnum == 3){
                ImageWPosX iLand = new ImageWPosX(posx, land4);
                listLandImage.add(iLand);
            }

        }

    }

    public void update(){
        for(ImageWPosX iLand: listLandImage){
            iLand.setXcooridnate((iLand.getXcooridnate()-6));
        }
        if(listLandImage.get(counter).getXcooridnate() == 0){
            ImageWPosX end = listLandImage.get(listLandImage.size()-1);
            Image landimage = land1;
            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                landimage = land1;
            } else if(randomnum == 1){
                landimage = land2;
            } else if(randomnum == 2){
                landimage = land3;
            } else if(randomnum == 3){
                landimage = land4;
            }
            ImageWPosX newaddition = new ImageWPosX((end.getXcooridnate()+300), landimage);
            listLandImage.add(newaddition);
            listLandImage.remove(0);
            //counter++;
        }

    }

    public void draw(Graphics g){
        for(int i = 0; i < listLandImage.size(); i++){
            g.drawImage(listLandImage.get(i).getImage(), listLandImage.get(i).getXcooridnate(), 78, null);
        }
    }

}
