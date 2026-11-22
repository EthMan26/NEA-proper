package main;

import Backrounds.backgroundManager;
import Collisions.Collisions;
import sprites.BaseEntity;
import sprites.EntityManager;
import sprites.Images;
import sprites.ImageEntity;
import sprites.player;
import java.awt.*;
import java.io.IOException;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    public int playerSize = 86;
    public int playerHeight = 86;
    public int playerWidth = 86;
    public int frameCounter = 0;
    public int screenWidth = 896;
    public int screenWidthMid = screenWidth /2;
    public int screenHeight = 672;
    public int screenHeightMid = screenHeight /2;
    Keys keyused = new Keys();
    Thread gameTime;
    EntityManager EM = new EntityManager(this);
    public double coordsX, coordsY = 0;
    double START_TIME = System.nanoTime();
    Images imageDealer = new Images();
    backgroundManager BM = new backgroundManager(this,EM,imageDealer);


    public int FPS =60;
    Collisions C = new Collisions(this);
    player you= new player(this,keyused, BM,EM,C);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyused);
        this.setFocusable(true);
    }

    public void start(){
        gameTime = new Thread(this);
        gameTime.start();
    }

    @Override
    public void run() {

        double drawTimeChange = 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        //int backgroundMult = 2;
        EM.initialEntitySetup();


        while(gameTime != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawTimeChange;
            lastTime = currentTime;
            if(delta >= 1){
                frameCounter ++;
                if (frameCounter == FPS){
                    frameCounter =0;
                }
                update();
                repaint();
                delta --;
            }
        }
    }
    public void update(){
        //ensure the getscreen Width etc are still relevant
        screenWidth = this.getWidth();
        screenHeight = this.getHeight();
        screenWidthMid = screenWidth/2;
        screenHeightMid = screenHeight/2;
        you.update();//run all the updates to the player and the movement of the player affecting points of where the entities are
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        // paint the entities
        for (ImageEntity entity:EM.allImageEntities) {
            BM.draw(g2, entity);
        }

        //paint the player
        you.paintComponent(g2);

        // using the paint component I have added the coordinates in the top left of the screen with a white background behind them,
        //It is here so it is always visible to the player for where they are
        //and also how long the game has been going on depended on speedrun mode
        g2.drawImage(imageDealer.getImageByIndex(6),0,0,250,55,null);
        g2.setColor(Color.CYAN);
        g2.setFont(new Font("Ink Free", Font.BOLD, 20));
        g2.drawString("COORDS: ("+(int)(coordsX/25)+" , "+(int)(coordsY/25)+")",15,30);

        g2.drawImage(imageDealer.getImageByIndex(6),screenWidth-250,0,250,55,null);
        g2.setColor(Color.CYAN);
        g2.setFont(new Font("Ink Free", Font.BOLD, 20));
        long displayTime = (long) ((System.nanoTime() - START_TIME)/10000000);
        int hundreths,seconds,minutes;
        hundreths = (int) displayTime%100;
        seconds = (int) displayTime / 100;
        minutes = seconds / 60;
        while(seconds>59){
            seconds -= 60;
        }
        g2.drawString("TIME: "+minutes+" : "+seconds+" : "+hundreths,screenWidth -200,30);
        g2.dispose();
        System.out.println(EM.allEntities.getFirst().getX());
    }
}