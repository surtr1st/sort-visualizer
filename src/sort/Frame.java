package sort;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame()
    {
        Control control = new Control();
        add(control);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
        setSize(1600,900);
        setVisible(true);
        setTitle("Sorting Algorithm Visualization");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Frame();
    }
}
