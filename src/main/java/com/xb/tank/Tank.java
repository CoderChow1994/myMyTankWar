package com.xb.tank;

import java.awt.*;

/**
 * @author Vincent.Chow
 * @date 2021/5/13 22:05
 * @description
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private TankFrame tankFrame;
    private final int SPEED = 5;

    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);
        move();
    }

    private void move() {
        if (!moving) return;
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
    }

    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
    }
}
