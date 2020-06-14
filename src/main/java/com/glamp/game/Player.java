/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glamp.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author glamb
 */
public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp2(x, -32, Game.WIDTH - 32);
        y = Game.clamp2(y, -32, Game.HEIGHT - 32);

         handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
        collision();
    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.BasicEnemy) { //tempObject is now Basic Enemy
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collission code
                    HUD.HEALTH -=2;
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.GREEN);
//        g2d.draw(getBounds());
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
