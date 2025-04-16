package Model;

public class Sparks extends Particle {

    static float startSpeed = 5;
    int lifespan = 100;

    public Sparks(ParticleEmitter p) {
        super(p);
        velocityX = ((Math.random() * 4 - 2) * startSpeed);
        velocityY = ((Math.random() * 4 - 2) * startSpeed);
    }

    public boolean isAlive() {
        if (getAge() < lifespan) {
            return true;
        } else {
            return false;
        }
    }
}