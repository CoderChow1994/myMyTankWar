import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Vincent.Chow
 * @date 2021/5/12 21:47
 * @description
 */
public class TankFrame extends Frame {
    public TankFrame()  {
        setResizable(false);
        setSize(800,600);
        setTitle("Tank");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
