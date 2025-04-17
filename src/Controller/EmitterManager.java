package Controller;

import Model.Particle;
import Model.ParticleEmitter;
import Model.ParticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EmitterManager {

    ArrayList<ParticleEmitter> emitters = new ArrayList<ParticleEmitter>();
    JPanel panel;

    public EmitterManager(JPanel panel) {
        this.panel = panel;
    }
    
    public void createEmitter(ParticleType type, int posX, int posY) {
        ParticleEmitter emitter = new ParticleEmitter(type, posX, posY);
        emitter.addParticle(1);
        emitters.add(emitter);
    }

    public BufferedImage updateImage(BufferedImage image) {

        Graphics2D g2d = image.createGraphics();
        // Set the color you want to fill
        g2d.setColor(new Color(0,0,0,0.8f));
        // Fill the entire image with the color
        g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g2d.dispose();

        for (ParticleEmitter emitter : emitters) {
            emitter.updateParticles();
            emitter.particleList.removeIf(p -> p.getPositionX() >= panel.getWidth() || p.getPositionX() <= 0);
            emitter.particleList.removeIf(p -> p.getPositionY() >= panel.getHeight() || p.getPositionY() <= 0);
            for (Particle p : emitter.particleList) {
                image.setRGB(p.getPositionX(), p.getPositionY(), p.getColor());
            }
        }
        return image;
    }
}