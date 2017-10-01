/*
Enigma Machine GUI
by Ben Avery
9/27/17
v1.4
 */

package EnigmaMachine;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GUI implements Runnable {
    public void run() {
        JFrame f = new JFrame("Enigma Machine Emulator");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;
        f.setPreferredSize(new Dimension(width, height));
        f.add(new JLabel("Enigma Machine Emulator"));
        f.pack();
        f.setVisible(true);
    }
}
