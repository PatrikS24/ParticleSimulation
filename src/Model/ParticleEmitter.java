package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleEmitter {
    private int positionX;
    private int positionY;
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

    public int getPositionX() {return positionX;}
    public int getPositionY() {return positionY;}
    public ParticleType getType() {return type;}

    public void updateParticles() {
        addParticle(1);
        Iterator<Particle> iterator = particleList.iterator();
        while (iterator.hasNext()) {
            Particle particle = iterator.next();
            particle.incrementAge();
            if (!particle.isAlive()) {
                iterator.remove();
            } else {
                particle.updateParticle();
            }
        }
    }

    public void addParticle() {
        particleList.add(particleFactory.createParticle(type));
    }

    public void addParticle(int numberOfParticles) {
        for (int i = 0; i <= numberOfParticles; i++) {
            addParticle();
        }
    }
}
