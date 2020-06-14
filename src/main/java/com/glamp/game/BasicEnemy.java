/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glamp.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author glamb
 */
public class BasicEnemy extends GameObject {

     private Handler handler;
     
    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;
        
        velX = 5;
        velY = 5;
        
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
        
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);        
    }

}
