package Controller;

import Model.Particle;
import Model.ParticleEmitter;
import Model.ParticleType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EmitterManager {

    ArrayList<ParticleEmitter> emitters = new ArrayList<ParticleEmitter>();
    
    public void createEmitter(ParticleType type, int posX, int posY) {
        ParticleEmitter emitter = new ParticleEmitter(type, posX, posY);
        emitter.addParticle(35);
        emitters.add(emitter);
    }

    public BufferedImage updateImage(BufferedImage image) {
        for (ParticleEmitter emitter : emitters) {
            emitter.updateParticles();
            for (Particle p : emitter.particleList) {
                image.setRGB(p.getPositionX(), p.getPositionY(), Color.black.getRGB());
            }
        }
        /*
        Graphics2D g2d = image.createGraphics();

        // Set the color you want to fill
        g2d.setColor(Color.black);

        // Fill the entire image with the color
        g2d.fillRect(0, 0, 500, 500);
        g2d.dispose();
        */

        return image;
    }
}