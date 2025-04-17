package View;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        // Set frame properties
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Particle Simulation");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        this.add(panel);
        this.setVisible(true);

    }
}
