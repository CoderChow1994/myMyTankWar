import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Vincent.Chow
 * @date 2021/5/12 21:14
 * @description
 */
public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setResizable(false);
        f.setSize(800,600);
        f.setTitle("Tank");
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
