package com.xb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent.Chow
 * @date 2021/5/12 21:47
 * @description
 */
public class TankFrame extends Frame {
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 800;

    Tank tank = new Tank(200, 200, Dir.DOWN, this);

    List<Bullet> bullets = new ArrayList<>();

    public TankFrame() {
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setTitle("Tank");
        setVisible(true);
        addKeyListener(new MyKeyListerner());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    /**
     * 绘画移动
     *
     * @param g
     */
    @Override

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.setColor(color);

        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    /**
     * 按键判断
     */
    class MyKeyListerner extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
            }
            //repaint();
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
            }

            setMainTankDir();
        }

        /**
         * 坦克方向
         */
        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD) {
                tank.setMoving(false);
                return;
            }
            tank.setMoving(true);
            if (bL) tank.setDir(Dir.LEFT);
            if (bU) tank.setDir(Dir.UP);
            if (bR) tank.setDir(Dir.RIGHT);
            if (bD) tank.setDir(Dir.DOWN);
        }
    }
}

