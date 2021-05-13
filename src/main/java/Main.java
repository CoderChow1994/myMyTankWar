import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Vincent.Chow
 * @date 2021/5/12 21:14
 * @description
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        while (true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}
