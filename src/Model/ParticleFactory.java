package Model;

public class ParticleFactory {
    private ParticleEmitter particleEmitter;

    public ParticleFactory(ParticleEmitter p) {
        particleEmitter = p;
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
