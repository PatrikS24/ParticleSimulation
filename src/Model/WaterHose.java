package Model;

import java.awt.*;

public class WaterHose extends Particle {

    private static float startSpeed = 4;
    private static float gravity = 1.5f;
    private static float airResistance = 0.9f;
    private static float hoseDirectionVariance = 0.04f;
    private static int maxHoseSpeed = 8;
    ParticleEmitter emitter;


    public WaterHose(ParticleEmitter p) {
        super(p);
        emitter = p;
        velocityX = p.hoseDirectionX * startSpeed;
        velocityY = p.hoseDirectionY * startSpeed;
        lifespan = 1000;
    }

    public void updateParticle() {
        velocityY *= airResistance;
        velocityX *= airResistance;
        velocityY += gravity;
        positionX += velocityX;
        positionY += velocityY;
        emitter.hoseDirectionX += hoseDirectionVariance * ((Math.random() * 4 - 2));
        emitter.hoseDirectionY += hoseDirectionVariance * ((Math.random() * 4 - 2));
        if (emitter.hoseDirectionX < -maxHoseSpeed) {
            emitter.hoseDirectionX = -maxHoseSpeed;
        } else if (emitter.hoseDirectionX > maxHoseSpeed) {
            emitter.hoseDirectionX = maxHoseSpeed;
        }
        if (emitter.hoseDirectionY < -maxHoseSpeed) {
            emitter.hoseDirectionY = -maxHoseSpeed;
        } else if (emitter.hoseDirectionY > maxHoseSpeed) {
            emitter.hoseDirectionY = maxHoseSpeed;
        }
        incrementAge();
    }

    public int getColor() {
        return Color.blue.getRGB();
    }
}
