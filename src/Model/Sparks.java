package Model;

import java.awt.*;

public class Sparks extends Particle {

    static float startSpeed = 5;
    int lifespan = (int)(Math.random() * 50 - 30) + 30;

    public Sparks(ParticleEmitter p) {
        super(p);
        velocityX = ((Math.random() * 4 - 2) * startSpeed);
        velocityY = ((Math.random() * 4 - 2) * startSpeed);
    }

    @Override
    public int getColor() {
        return new Color(255,255,0,lifespan/getAge()).getRGB();
    }

    public boolean isAlive() {
        if (getAge() < lifespan) {
            return true;
        } else {
            return false;
        }
    }
}