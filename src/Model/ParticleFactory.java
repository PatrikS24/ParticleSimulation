package Model;

public class ParticleFactory {
    private ParticleEmitter particleEmitter;

    public ParticleFactory(ParticleEmitter p) {
        particleEmitter = p;
    }

    public Particle createParticle(ParticleType particleType) {
        switch (particleType) {
            case ParticleType.SPARK:
                return new Spark(particleEmitter);
            case ParticleType.EMBER:
                return new Ember(particleEmitter);
            case ParticleType.WATERHOSE:
                return new WaterHose(particleEmitter);
        }
        return null;
    }
}
