package com.company.objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle {

    private Image mushroom1;
    private Image mushroom2;
    private Image grass;
    private Image flower;
    private Image bush;
    private Image empty;
    private ArrayList<ImageWPosX> listObstacleImage;
    private int counter = 1;
    private ArrayList<Rectangle> hitbox;

    public Obstacle() throws IOException {

        BufferedImage bufferedobstacle1pic = null;
        BufferedImage bufferedobstacle2pic = null;
        BufferedImage bufferedobstacle3pic = null;
        BufferedImage bufferedobstacle4pic = null;
        BufferedImage bufferedobstacle5pic = null;
        BufferedImage bufferedemptypic = null;

        try {
            bufferedobstacle1pic = ImageIO.read(new File("mushroom1.png"));
            bufferedobstacle2pic = ImageIO.read(new File("mushroom2.png"));
            bufferedobstacle3pic = ImageIO.read(new File("flower.png"));
            bufferedobstacle4pic = ImageIO.read(new File("bush.png"));
            bufferedobstacle5pic = ImageIO.read(new File("grass.png"));
            bufferedemptypic = ImageIO.read(new File("emptypic.png"));
        } catch (IOException e) {
        }
        Image mushroom1 = bufferedobstacle1pic.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image mushroom2 = bufferedobstacle2pic.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        Image flower = bufferedobstacle3pic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image bush = bufferedobstacle4pic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image grass = bufferedobstacle5pic.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        Image empty = bufferedemptypic.getScaledInstance(175, 175, Image.SCALE_SMOOTH);

        this.mushroom1 = mushroom1;
        this.mushroom2 = mushroom2;
        this.flower = flower;
        this.bush = bush;
        this.grass = grass;
        this.empty = empty;
        this.hitbox = new ArrayList<Rectangle>();

        this.listObstacleImage = new ArrayList<ImageWPosX>();
        for(int i = 0; i < 8; i++) {
            Random random = new Random();
            int number = (random.nextInt(10) * 10) + 300;
            int posx = number * i;

            ImageWPosX iObstacle = new ImageWPosX(posx, empty, 4);
            Rectangle rect = new Rectangle(80, 100);
            listObstacleImage.add(iObstacle);
            hitbox.add(rect);
 /*
            Random random = new Random();
            int number = (random.nextInt(10)*10) + 300;
            int posx = number*i;

            if (i == 7) {
                Random rand = new Random();
                int randomnum = rand.nextInt(5);
                System.out.println(randomnum);
                if (randomnum == 0) {
                    iObstacle = new ImageWPosX(posx, mushroom1, 0);
                    Rectangle mushrooom1 = new Rectangle(62, 150);
                    listObstacleImage.add(iObstacle);
                    hitbox.add(mushrooom1);
                } else if (randomnum == 1) {
                    iObstacle = new ImageWPosX(posx, mushroom2, 1);
                    Rectangle mushrooom2 = new Rectangle(125, 150);
                    listObstacleImage.add(iObstacle);
                    hitbox.add(mushrooom2);
                } else if (randomnum == 2) {
                    iObstacle = new ImageWPosX(posx, flower, 2);
                    Rectangle flower1 = new Rectangle(84, 150);
                    listObstacleImage.add(iObstacle);
                    hitbox.add(flower1);
                } else if (randomnum == 3) {
                    iObstacle = new ImageWPosX(posx, bush, 3);
                    Rectangle bush1 = new Rectangle(110, 100);
                    listObstacleImage.add(iObstacle);
                    hitbox.add(bush1);
                } else if (randomnum == 4) {
                    iObstacle = new ImageWPosX(posx, grass, 4);
                    Rectangle grass1 = new Rectangle(80, 100);
                    listObstacleImage.add(iObstacle);
                    hitbox.add(grass1);
                }

            }

  */
        }


    }

    public void update(){
        for(ImageWPosX iObstacle: listObstacleImage){
            iObstacle.setXcooridnate((iObstacle.getXcooridnate()-4));
        }

        if(listObstacleImage.get(counter).getXcooridnate() <= 0){
            ImageWPosX end = listObstacleImage.get(listObstacleImage.size()-1);
            Image landimage = mushroom1;
            int num = 0;
            Random rand = new Random();
            int randomnum = rand.nextInt(5);
            if(randomnum == 0){
                landimage = mushroom1;
                num = 0;
                Rectangle mushrooom1 = new Rectangle(62, 150);
                hitbox.add(mushrooom1);
            } else if(randomnum == 1){
                landimage = mushroom2;
                num = 1;
                Rectangle mushrooom2 = new Rectangle(125, 150);
                hitbox.add(mushrooom2);
            } else if(randomnum == 2){
                landimage = flower;
                num = 2;
                Rectangle sign1 = new Rectangle(84, 150);
                hitbox.add(sign1);
            } else if(randomnum == 3){
                landimage = bush;
                num = 3;
                Rectangle bush1 = new Rectangle(110, 100);
                hitbox.add(bush1);
            } else if(randomnum == 4){
                landimage = grass;
                num = 4;
                Rectangle grass1 = new Rectangle(80, 100);
                hitbox.add(grass1);
            }
            Random random = new Random();
            int number = (random.nextInt(10)*10) + 300;
            ImageWPosX newaddition = new ImageWPosX((end.getXcooridnate()+number), landimage, num);
            listObstacleImage.add(newaddition);
            counter++;
        }

    }

    public void draw(Graphics g){
        for (int i = 0; i < listObstacleImage.size()-2; i++){
                if (listObstacleImage.get(i).getNum() == 0) {
                    g.drawImage(listObstacleImage.get(i).getImage(), listObstacleImage.get(i).getXcooridnate(), 175, null);
                    g.drawRect(listObstacleImage.get(i).getXcooridnate() + 43, 207, hitbox.get(i).width, hitbox.get(i).height);
                } else if (listObstacleImage.get(i).getNum() == 2) {
                    g.drawImage(listObstacleImage.get(i).getImage(), listObstacleImage.get(i).getXcooridnate(), 132, null);
                    g.drawRect(listObstacleImage.get(i).getXcooridnate() + 55, 207, hitbox.get(i).width, hitbox.get(i).height);
                } else if (listObstacleImage.get(i).getNum() == 1) {
                    g.drawImage(listObstacleImage.get(i).getImage(), listObstacleImage.get(i).getXcooridnate(), 154, null);
                    g.drawRect(listObstacleImage.get(i).getXcooridnate() + 12, 178, hitbox.get(i).width, hitbox.get(i).height);
                } else if (listObstacleImage.get(i).getNum() == 3) {
                    g.drawImage(listObstacleImage.get(i).getImage(), listObstacleImage.get(i).getXcooridnate(), 140, null);
                    g.drawRect(listObstacleImage.get(i).getXcooridnate() + 45, 230, hitbox.get(i).width, hitbox.get(i).height);
                } else if (listObstacleImage.get(i).getNum() == 4) {
                    g.drawImage(listObstacleImage.get(i).getImage(), listObstacleImage.get(i).getXcooridnate(), 175, null);
                    g.drawRect(listObstacleImage.get(i).getXcooridnate() + 50, 228, hitbox.get(i).width, hitbox.get(i).height);
                }
        }
    }


}
