package com.xb.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Vincent.Chow
 * @date 2021/5/12 21:47
 * @description
 */
public class TankFrame extends Frame {
    Tank tank = new Tank(200, 200, Dir.DOWN);

    public TankFrame() {
        setResizable(false);
        setSize(800, 600);
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

    /**
     * 绘画移动
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        tank.paint(g);

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
            if (bL) tank.setDir(Dir.LEFT);
            if (bU) tank.setDir(Dir.UP);
            if (bR) tank.setDir(Dir.RIGHT);
            if (bD) tank.setDir(Dir.DOWN);
        }
    }
}

