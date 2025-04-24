package Model;

import java.awt.*;

public class Spark extends Particle {

    private static float startSpeed = 8;
    private static float gravity = 1.5f;
    private static float airResistance = 0.9f;

    public Spark(ParticleEmitter p) {
        super(p);
        velocityX = ((Math.random() * 4 - 2) * startSpeed);
        velocityY = ((Math.random() * 4 - 2) * startSpeed);
        lifespan = (int)(Math.random() * 30 - 10) + 10;
    }

    public void updateParticle() {
        velocityY *= airResistance;
        velocityX *= airResistance;
        velocityY += gravity;
        positionX += velocityX;
        positionY += velocityY;
        incrementAge();
    }

    @Override
    public int getColor() {
        int colorValue = (int)(255 * (1 - ((float)getAge()/(float)lifespan)));
        int exponentialColorValue = (int)(255 * Math.pow(colorValue / 255.0, 0.1));
        return new Color(exponentialColorValue, exponentialColorValue, 0).getRGB();
    }
}