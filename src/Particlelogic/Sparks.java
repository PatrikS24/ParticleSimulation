package Particlelogic;

public class Sparks extends Particle {

    static float startSpeed = 5;
    int lifespan = 100;

    public Sparks(ParticleEmitter p) {
        super(p);
        velocityX = ((Math.random() * 4 - 2) * startSpeed);
        velocityY = ((Math.random() * 4 - 2) * startSpeed);
    }

    public void updateParticle() {
        velocityY *= 0.8f;
        velocityX *= 0.8f;
        velocityY -= gravity;
        positionX += velocityX;
        positionY += velocityY;
        incrementAge();
    }

    public boolean isAlive() {
        if (getAge() > lifespan) {
            return true;
        } else {
            return false;
        }
    }
}