package UI_patricle_manager;

import Particlelogic.Particle;
import Particlelogic.ParticleEmitter;
import Particlelogic.ParticleType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EmitterManager {

    ArrayList<ParticleEmitter> emitters;
    
    public void createSparksEmitter(ParticleType type, int posX, int posY) {
        ParticleEmitter emitter = new ParticleEmitter(type, posX, posY);
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