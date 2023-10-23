package com.company.objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Sky {

    private Image sky1layer1;
    private Image sky1layer2;
    private Image sky2layer1;
    private Image sky2layer2;
    private Image sky3layer1;
    private Image sky3layer2;
    private Image sky4layer1;
    private Image sky4layer2;
    private Image cloud1layer1;
    private Image cloud1layer2;
    private Image cloud2layer1;
    private Image cloud2layer2;
    private Image cloud3layer1;
    private Image cloud3layer2;
    private Image cloud4layer1;
    private Image cloud4layer2;
    private ArrayList<ImageWPosX> listSkyImagelayer1;
    private ArrayList<ImageWPosX> listSkyImagelayer2;
    private ArrayList<ImageWPosX> listSkyImagelayer3;
    private ArrayList<ImageWPosX> listSkyImagelayer4;
    private int counterlayer1 = 1;
    private int counterlayer2 = 1;
    private int counterlayer3 = 1;
    private int counterlayer4 = 1;

    public Sky() throws IOException {

        BufferedImage bufferedsky1layer1pic = null;
        BufferedImage bufferedsky1layer2pic = null;
        BufferedImage bufferedsky2layer1pic = null;
        BufferedImage bufferedsky2layer2pic = null;
        BufferedImage bufferedsky3layer1pic = null;
        BufferedImage bufferedsky3layer2pic = null;
        BufferedImage bufferedsky4layer1pic = null;
        BufferedImage bufferedsky4layer2pic = null;
        BufferedImage bufferedcloud1layer1pic = null;
        BufferedImage bufferedcloud1layer2pic = null;
        BufferedImage bufferedcloud2layer1pic = null;
        BufferedImage bufferedcloud2layer2pic = null;
        BufferedImage bufferedcloud3layer1pic = null;
        BufferedImage bufferedcloud3layer2pic = null;
        BufferedImage bufferedcloud4layer1pic = null;
        BufferedImage bufferedcloud4layer2pic = null;

        try {
            bufferedsky1layer1pic = ImageIO.read(new File("sky1layer1.png"));
            bufferedsky1layer2pic = ImageIO.read(new File("sky1layer2.png"));
            bufferedsky2layer1pic = ImageIO.read(new File("sky2layer1.png"));
            bufferedsky2layer2pic = ImageIO.read(new File("sky2layer2.png"));
            bufferedsky3layer1pic = ImageIO.read(new File("sky3layer1.png"));
            bufferedsky3layer2pic = ImageIO.read(new File("sky3layer2.png"));
            bufferedsky4layer1pic = ImageIO.read(new File("sky4layer1.png"));
            bufferedsky4layer2pic = ImageIO.read(new File("sky4layer2.png"));
            bufferedcloud1layer1pic = ImageIO.read(new File("cloud1layer1.png"));
            bufferedcloud1layer2pic = ImageIO.read(new File("cloud1layer2.png"));
            bufferedcloud2layer1pic = ImageIO.read(new File("cloud2layer1.png"));
            bufferedcloud2layer2pic = ImageIO.read(new File("cloud2layer2.png"));
            bufferedcloud3layer1pic = ImageIO.read(new File("cloud3layer1.png"));
            bufferedcloud3layer2pic = ImageIO.read(new File("cloud3layer2.png"));
            bufferedcloud4layer1pic = ImageIO.read(new File("cloud4layer1.png"));
            bufferedcloud4layer2pic = ImageIO.read(new File("cloud4layer2.png"));

        } catch (IOException e) {
        }
        this.sky1layer1 = bufferedsky1layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky1layer2 = bufferedsky1layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky2layer1 = bufferedsky2layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky2layer2 = bufferedsky2layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky3layer1 = bufferedsky3layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky3layer2 = bufferedsky3layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky4layer1 = bufferedsky4layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.sky4layer2 = bufferedsky4layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud1layer1 = bufferedcloud1layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud1layer2 = bufferedcloud1layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud2layer1 = bufferedcloud2layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud2layer2 = bufferedcloud2layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud3layer1 = bufferedcloud3layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud3layer2 = bufferedcloud3layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud4layer1 = bufferedcloud4layer1pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        this.cloud4layer2 = bufferedcloud4layer2pic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);


        listSkyImagelayer1 = new ArrayList<ImageWPosX>();
        listSkyImagelayer2 = new ArrayList<ImageWPosX>();
        listSkyImagelayer3 = new ArrayList<ImageWPosX>();
        listSkyImagelayer4 = new ArrayList<ImageWPosX>();
        for(int i = 0; i < 8; i++){
            int posx = 300*i;
            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                ImageWPosX iSkylayer1 = new ImageWPosX(posx, sky1layer1);
                ImageWPosX iSkylayer2 = new ImageWPosX(posx, sky1layer2);
                ImageWPosX iSkylayer3 = new ImageWPosX(posx, cloud1layer1);
                ImageWPosX iSkylayer4 = new ImageWPosX(posx, cloud1layer2);
                listSkyImagelayer1.add(iSkylayer1);
                listSkyImagelayer2.add(iSkylayer2);
                listSkyImagelayer3.add(iSkylayer3);
                listSkyImagelayer4.add(iSkylayer4);
            } else if(randomnum == 1){
                ImageWPosX iSkylayer1 = new ImageWPosX(posx, sky2layer1);
                ImageWPosX iSkylayer2 = new ImageWPosX(posx, sky2layer2);
                ImageWPosX iSkylayer3 = new ImageWPosX(posx, cloud2layer1);
                ImageWPosX iSkylayer4 = new ImageWPosX(posx, cloud2layer2);
                listSkyImagelayer1.add(iSkylayer1);
                listSkyImagelayer2.add(iSkylayer2);
                listSkyImagelayer3.add(iSkylayer3);
                listSkyImagelayer4.add(iSkylayer4);
            } else if(randomnum == 2){
                ImageWPosX iSkylayer1 = new ImageWPosX(posx, sky3layer1);
                ImageWPosX iSkylayer2 = new ImageWPosX(posx, sky3layer2);
                ImageWPosX iSkylayer3 = new ImageWPosX(posx, cloud3layer1);
                ImageWPosX iSkylayer4 = new ImageWPosX(posx, cloud3layer2);
                listSkyImagelayer1.add(iSkylayer1);
                listSkyImagelayer2.add(iSkylayer2);
                listSkyImagelayer3.add(iSkylayer3);
                listSkyImagelayer4.add(iSkylayer4);
            } else if(randomnum == 3){
                ImageWPosX iSkylayer1 = new ImageWPosX(posx, sky4layer1);
                ImageWPosX iSkylayer2 = new ImageWPosX(posx, sky4layer2);
                ImageWPosX iSkylayer3 = new ImageWPosX(posx, cloud4layer1);
                ImageWPosX iSkylayer4 = new ImageWPosX(posx, cloud4layer2);
                listSkyImagelayer1.add(iSkylayer1);
                listSkyImagelayer2.add(iSkylayer2);
                listSkyImagelayer3.add(iSkylayer3);
                listSkyImagelayer4.add(iSkylayer4);
            }
        }
    }

    public void updatelayer1(){
        for(ImageWPosX iSkylayer1: listSkyImagelayer1){
            iSkylayer1.setXcooridnate((iSkylayer1.getXcooridnate()-1));
        }

        if(listSkyImagelayer1.get(counterlayer1).getXcooridnate() == 0){
            ImageWPosX end = listSkyImagelayer1.get(listSkyImagelayer1.size()-1);
            Image skyimagelayer1 = sky1layer1;

            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                skyimagelayer1 = sky1layer1;
            } else if(randomnum == 1){
                skyimagelayer1 = sky2layer1;
            } else if(randomnum == 2){
                skyimagelayer1 = sky3layer1;
            } else if(randomnum == 3){
                skyimagelayer1 = sky4layer1;
            }
            ImageWPosX newskyimagelayer1 = new ImageWPosX((end.getXcooridnate()+300), skyimagelayer1);
            listSkyImagelayer1.add(newskyimagelayer1);
            counterlayer1++;
        }
    }

    public void updatelayer2(){
        for(ImageWPosX iSkylayer2: listSkyImagelayer2){
            iSkylayer2.setXcooridnate((iSkylayer2.getXcooridnate()-3));
        }

        if(listSkyImagelayer2.get(counterlayer2).getXcooridnate() == 0){
            ImageWPosX end = listSkyImagelayer2.get(listSkyImagelayer2.size()-1);
            Image skyimagelayer2 = sky1layer2;

            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                skyimagelayer2 = sky1layer2;
            } else if(randomnum == 1){
                skyimagelayer2 = sky2layer2;
            } else if(randomnum == 2){
                skyimagelayer2 = sky3layer2;
            } else if(randomnum == 3){
                skyimagelayer2 = sky4layer2;
            }
            ImageWPosX newskyimagelayer2 = new ImageWPosX((end.getXcooridnate()+300), skyimagelayer2);
            listSkyImagelayer2.add(newskyimagelayer2);
            counterlayer2++;
        }
    }

    public void updatelayer3(){
        for(ImageWPosX iSkylayer3: listSkyImagelayer3){
            iSkylayer3.setXcooridnate((iSkylayer3.getXcooridnate()-2));
        }

        if(listSkyImagelayer3.get(counterlayer3).getXcooridnate() == 0){
            ImageWPosX end = listSkyImagelayer3.get(listSkyImagelayer3.size()-1);
            Image skyimagelayer3 = cloud1layer1;

            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                skyimagelayer3 = cloud1layer1;
            } else if(randomnum == 1){
                skyimagelayer3 = cloud2layer1;
            } else if(randomnum == 2){
                skyimagelayer3 = cloud3layer1;
            } else if(randomnum == 3){
                skyimagelayer3 = cloud4layer1;
            }
            ImageWPosX newskyimagelayer3 = new ImageWPosX((end.getXcooridnate()+300), skyimagelayer3);
            listSkyImagelayer3.add(newskyimagelayer3);
            counterlayer3++;
        }
    }

    public void updatelayer4(){
        for(ImageWPosX iSkylayer4: listSkyImagelayer4){
            iSkylayer4.setXcooridnate((iSkylayer4.getXcooridnate()-4));
        }

        if(listSkyImagelayer4.get(counterlayer4).getXcooridnate() == 0){
            ImageWPosX end = listSkyImagelayer4.get(listSkyImagelayer4.size()-1);
            Image skyimagelayer4 = cloud1layer2;

            Random rand = new Random();
            int randomnum = rand.nextInt(4);
            if(randomnum == 0){
                skyimagelayer4 = cloud1layer2;
            } else if(randomnum == 1){
                skyimagelayer4 = cloud2layer2;
            } else if(randomnum == 2){
                skyimagelayer4 = cloud3layer2;
            } else if(randomnum == 3){
                skyimagelayer4 = cloud4layer2;
            }
            ImageWPosX newskyimagelayer4 = new ImageWPosX((end.getXcooridnate()+300), skyimagelayer4);
            listSkyImagelayer4.add(newskyimagelayer4);
            counterlayer4++;
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < listSkyImagelayer1.size()-2; i++){
            g.drawImage(listSkyImagelayer1.get(i).getImage(), listSkyImagelayer1.get(i).getXcooridnate(), 0, null);
        }
        for(int i = 0; i < listSkyImagelayer3.size()-2; i++){
            g.drawImage(listSkyImagelayer3.get(i).getImage(), listSkyImagelayer3.get(i).getXcooridnate(), 0, null);
        }
        for(int i = 0; i < listSkyImagelayer2.size()-2; i++){
            g.drawImage(listSkyImagelayer2.get(i).getImage(), listSkyImagelayer2.get(i).getXcooridnate(), 0, null);
        }
        for(int i = 0; i < listSkyImagelayer4.size()-2; i++){
            g.drawImage(listSkyImagelayer4.get(i).getImage(), listSkyImagelayer4.get(i).getXcooridnate(), 0, null);
        }
    }

}
