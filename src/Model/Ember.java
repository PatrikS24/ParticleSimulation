package Model;

import java.awt.*;

public class Ember extends Particle{

    private static float startSpeed = 0.5f;
    private static float floatFactor = 0.03f;
    private static float spreadFactor = 0.035f;
    private static float maxWindSpeed = 0.05f;
    private static int flickerSpeed = 4;
    private float windDirection;

    public Ember(ParticleEmitter p) {
        super(p);
        velocityX = ((Math.random() * 4 - 2) * startSpeed);
        velocityY = ((Math.random() * -2) * startSpeed);
        lifespan = (int)(Math.random() * 200 - 100) + 100;
        windDirection = (float)(Math.random() * 2 - 1) * spreadFactor;
    }

    private void windDirectionUpdate() {
        windDirection = windDirection + (float)((Math.random() * 2 - 1) * spreadFactor);
    }

    public void updateParticle() {
        velocityY -= floatFactor;
        positionX += velocityX;
        positionY += velocityY;
        incrementAge();
        windDirectionUpdate();
        velocityX += windDirection;
        if (windDirection < -maxWindSpeed) {
            windDirection = -maxWindSpeed;
        } else if (windDirection > maxWindSpeed) {
            windDirection = maxWindSpeed;
        }
    }

    @Override
    public int getColor() {
        double flickerPhase = (Math.cos(((double) 1 / flickerSpeed) * getAge()) + 1) / 2;
        return new Color(255,(int)(flickerPhase * (174 - 69)) + 69,(int)(flickerPhase * 45)).getRGB();
    }

}
