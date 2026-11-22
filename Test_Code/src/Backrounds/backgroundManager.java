package Backrounds;

import main.GamePanel;
import sprites.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class backgroundManager {
    Images imageGuy ;
    EntityManager EM;
    public BufferedImage WHITE;

    public backgroundManager(GamePanel gamePanel, EntityManager EM,Images imageGuy) {
        this.EM = EM;
        this.imageGuy = imageGuy;
    }


    public void playerHitLeft(double speed){
        for(BaseEntity currentEntity:EM.allEntities){
            currentEntity.offsetAllX(speed);
        }
    }

    public void playerHitRight(double speed){
        for(BaseEntity currentEntity:EM.allEntities){
            currentEntity.offsetAllX(-speed);
        }
    }

    public void playerHitTop(double speed){
        for(BaseEntity currentEntity:EM.allEntities){
            currentEntity.offsetAllY(speed);
        }
    }

    public void playerHitBottom(double speed){
        for(BaseEntity currentEntity:EM.allEntities){
            currentEntity.offsetAllY(-speed);
        }
    }

    public void draw(Graphics2D g2, ImageEntity i){
        g2.drawImage(imageGuy.getImageByIndex(i.getImageIndex()),(int)i.getImageX(),(int)i.getImageY(),(int)i.getImageWidth(),(int)i.getImageHeight(),null);
    }
}