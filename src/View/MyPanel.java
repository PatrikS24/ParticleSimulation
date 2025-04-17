package View;

import Controller.EmitterManager;
import Model.ParticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class MyPanel extends JPanel implements ActionListener {
    EmitterManager emitterManager;
    BufferedImage image;
    Timer timer;

    MyPanel() {
        emitterManager = new EmitterManager(this);
        image = createBufferedImage();
        timer = new Timer(16,this);
        timer.start();
        emitterManager.createEmitter(ParticleType.SPARKS, 250,250);
    }

    public BufferedImage createBufferedImage() {
        return new BufferedImage(500, 500, TYPE_INT_ARGB);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emitterManager.updateImage(image);
        repaint();
    }
}
