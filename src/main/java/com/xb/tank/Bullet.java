package com.xb.tank;

import java.awt.*;

/**
 * @author Vincent.Chow
 * @date 2021/5/13 22:34
 * @description
 */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH=15,HEIGHT = 15;

    private boolean live =true;
    private int x,y;
    private Dir dir;
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        if (!live){
            tf.bullets.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }
}
