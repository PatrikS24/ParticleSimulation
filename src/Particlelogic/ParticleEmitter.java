package Particlelogic;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleEmitter {
    int positionX;
    int positionY;
    private final ParticleType type;
    public ArrayList<Particle> particleList;
    ParticleFactory particleFactory;

    public ParticleEmitter(ParticleType type, int posX, int posY) {
        this.type = type;
        positionX = posX;
        positionY = posY;
        particleFactory = new ParticleFactory(this);
        particleList = new ArrayList<Particle>();
    }

    public void updateParticles() {
        Iterator<Particle> iterator = particleList.iterator();
        while (iterator.hasNext()) {
            Particle particle = iterator.next();
            if (!particle.isAlive()) {
                iterator.remove();
            } else {
                particle.updateParticle();
            }
        }
    }

    void addParticle() {
        particleList.add(particleFactory.createParticle(type));
    }

    void addParticle(int numberOfParticles) throws Exception {
        for (int i = 0; i <= numberOfParticles; i++) {
            addParticle();
        }
    }
}
