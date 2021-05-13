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
    int x = 200;
    int y = 200;

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

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        x += 10;
//        y += 10;
    }

    class MyKeyListerner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            x += 10;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}

