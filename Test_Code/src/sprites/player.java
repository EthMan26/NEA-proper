package sprites;
import main.GamePanel;
import main.Keys;
import Backrounds.backgroundManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class player extends playerElements{
    GamePanel gp;
    Keys key;
    backgroundManager BM;
    public int everyYnth = 0, everyXnth =0;
    public int nth = 5;
    /*
    public double sinWave = 0;
    public int bobMultiplyer =6;
    public double bobTimePeriod =10;
     */

    public player(GamePanel gp,Keys key,backgroundManager BM){
        this.gp = gp;
        this.key = key;
        this.BM =BM;
        defaultPlayer(gp.screenWidthMid-(gp.playerSize/2),gp.screenHeightMid-(gp.playerSize/2),5,5);
        getPlayerVisuals();
    }

    public void defaultPlayer(int x,int y, int maxvy, int maxvx){
        this.x =x;
        this.y =y;
        this.width =gp.playerWidth;
        this.height =gp.playerHeight;
        this.currentxv = 0;
        this.currentyv = 0;
        this.maxxv = maxvx;
        this.maxyv = maxvy;
        direction = "up";
    }


    public void getPlayerVisuals(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/up_1.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/up_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/left_4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/right_4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down_2.png"));
            dft = ImageIO.read(getClass().getResourceAsStream("/player/dft.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        boolean xpress = false,ypress = false;
        if (key.up || key.down || key.left || key.right) {
            if (!(key.up && key.down)) {
                if (key.up) {
                    ypress = true;
                    direction = "up";
                    if (currentyv > (-maxyv)) {
                        everyYnth++;
                        if (everyYnth == nth) {
                            currentyv--;
                            everyYnth = 0;
                        }
                    }

                }
                if (key.down) {
                    ypress = true;
                    direction = "down";
                    if (currentyv < maxyv) {
                        everyYnth++;
                        if (everyYnth == nth) {
                            currentyv++;
                            everyYnth = 0;
                        }
                    }

                }
            }
            if (!(key.left && key.right)){
                if (key.left) {
                    xpress =true;
                    direction = "left";
                    if (currentxv > (-maxxv)){
                        everyXnth++;
                        if (everyXnth == nth) {
                            currentxv--;
                            everyXnth = 0;
                        }
                    }

                }
                if (key.right) {
                    xpress = true;
                    direction = "right";
                    if (currentxv < maxxv) {
                        everyXnth++;
                        if (everyXnth == nth) {
                            currentxv++;
                            everyXnth = 0;
                        }
                    }

                }
            }
        } else {
            direction = "default";
        }
        if((!ypress)&&Math.abs(currentyv)>0){
            everyYnth++;
            if (everyYnth==nth){
                if(currentyv>0){
                    currentyv--;
                }else{
                    currentyv++;
                }
                everyYnth=0;
            }
        }
        if((!xpress)&&Math.abs(currentxv)>0){
            everyXnth++;
            if (everyXnth==nth){
                if(currentxv>0){
                    currentxv--;
                }else{
                    currentxv++;
                }
                everyXnth=0;
            }
        }


        y += currentyv;
        gp.coordsY -= currentyv;
        x += currentxv;
        gp.coordsX += currentxv;
        //Player edge of screen check, will see if the player is at the edge of the screen, and will move the backround accordingly
        //will have to add collision checker prior in chronologicality
        //sticky movement
        //overcompliacted by adding the diff twice
        if (x < 100) {
            int diff = 100-x;
            x = 100;
            BM.playerHitLeft(diff);

        } else if (x > (gp.screenWidth - gp.playerSize) -100) {
            int diff = x - ((gp.screenWidth - gp.playerSize) - 100);
            x = (gp.screenWidth - gp.playerSize) -100;
            BM.playerHitRight(diff);
        }

        if (y < 100) {
            int diff = 100-y;
            y = 100;
            BM.playerHitTop(diff);

        } else if (y > (gp.screenHeight - gp.playerSize) -100) {
            int diff = y - ((gp.screenHeight - gp.playerSize) - 100);
            y = (gp.screenHeight - gp.playerSize) -100;
            BM.playerHitBottom(diff);
        }

        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum < 4) {
                spriteNum++;
            } else if (spriteNum == 4) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void paintComponent(Graphics g2){

        BufferedImage img = null;

        switch (direction){
            case "up":
                if(spriteNum==1) {
                    img = up1;
                }if(spriteNum==2){
                    img = up2;
                }if(spriteNum==3){
                    img = up3;
                }if(spriteNum==4){
                    img = up4;
                }
                break;
            case "down":
                if(spriteNum==1) {
                    img = down1;
                }if(spriteNum==2) {
                    img = down2;
                }
                break;
            case "left":
                if(spriteNum==1) {
                    img = left1;
                }if(spriteNum==2){
                    img = left2;
                }if(spriteNum==3) {
                    img = left3;
                }if(spriteNum==4){
                    img = left4;
                }
                break;
            case "right":
                if(spriteNum==1) {
                    img = right1;
                }if(spriteNum==2){
                    img = right2;
                }if(spriteNum==3){
                    img = right3;
                }if(spriteNum==4){
                    img = right4;
                }
                break;
            case "default":
                img =dft;
                break;

        }
        if (currentxv==0 && currentyv==0) {
            img = dft;
        }/*
        int drawnx = x, drawny=y, drawnHeight=gp.playerHeight, drawnWidth = gp.playerWidth;
        sinWave += ((2*Math.PI)/(bobTimePeriod*gp.FPS));
        if (sinWave > (2*Math.PI)){
            sinWave = 0;
        }
        double adjuster = Math.round(bobMultiplyer * Math.sin(sinWave));
        //the point at the center bottom of the player should not move at yofCB = y+Height and xofCB = x+ (Width)/2
        drawny +=  adjuster;
        drawnHeight -=adjuster;
        */
        g2.drawImage(img,x,y,width,height,null);
    }
}