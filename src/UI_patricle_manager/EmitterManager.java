package UI_patricle_manager;

import Particlelogic.Particle;
import Particlelogic.ParticleEmitter;
import Particlelogic.ParticleType;
import Particlelogic.Sparks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EmitterManager {

    ArrayList<ParticleEmitter> emitters;
    
    public void createSparksEmitter(int posX, int posY) {
        ParticleEmitter emitter = new ParticleEmitter(ParticleType.SPARKS,posX, posY);
        emitters.add(emitter);
    }

    public BufferedImage updateImage(BufferedImage image) {
        for (ParticleEmitter emitter:emitters) {
            emitter.updateParticles();
            for (Particle p : (ArrayList<Particle>) emitter.particleList) {
                image.setRGB(p.getPositionX(), p.getPositionY(), Color.white.getRGB());
            }
        }
        return image;
    }
}
