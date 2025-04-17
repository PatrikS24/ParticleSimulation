package Model;

public class ParticleFactory {
    private ParticleEmitter particleEmitter;

    public ParticleFactory(ParticleEmitter p) {
        particleEmitter = p;
    }

    public Particle createParticle(ParticleType particleType) {
        Particle newParticle = null;

        switch (particleType) {
            case ParticleType.SPARKS:
                newParticle = new Sparks(particleEmitter);
        }
        return newParticle;
    }
}
