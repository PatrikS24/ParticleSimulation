package View;

import Controller.EmitterManager;
import Model.ParticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class MyPanel extends JPanel {
    EmitterManager emitterManager;
    BufferedImage image;

    MyPanel() {
        emitterManager = new EmitterManager();
        image = createBufferedImage();
        emitterManager.createEmitter(ParticleType.SPARKS, 250,250);
        emitterManager.updateImage(image);
        repaint();
    }

    public BufferedImage createBufferedImage() {
        return new BufferedImage(500, 500, TYPE_INT_ARGB);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
