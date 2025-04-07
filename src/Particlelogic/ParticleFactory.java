package Particlelogic;

public class ParticleFactory {
    int particlePosX;
    int particlePosY;
    ParticleEmitter particleEmitter;

    public ParticleFactory(ParticleEmitter p) {
        particlePosX = p.positionX;
        particlePosY = p.positionY;
    }

    public Particle createParticle(ParticleType particleType) {
        Particle returnParticle = null;

        switch (particleType) {
            case SPARKS:
                returnParticle = new Sparks(particleEmitter);
                break;
        }
        return returnParticle;
    }
}
