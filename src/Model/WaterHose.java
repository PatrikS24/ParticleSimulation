package Model;

public class WaterHose extends Particle {

    private static float startSpeed = 8;
    private static float gravity = 1.5f;
    private static float airResistance = 0.9f;
    private static double hoseDirectionX = 0;
    private static double hoseDirectionY = 1;
    private static float hoseDirectionVariance = 0.01f;


    public WaterHose(ParticleEmitter p) {
        super(p);
        velocityX = hoseDirectionX;
        velocityY = hoseDirectionY;
        lifespan = (int)(Math.random() * 30 - 10) + 10;
    }

    public void updateParticle() {
        velocityY *= airResistance;
        velocityX *= airResistance;
        velocityY += gravity;
        positionX += velocityX;
        positionY += velocityY;
        hoseDirectionX += hoseDirectionVariance * ((Math.random() * 4 - 2) * startSpeed);
        hoseDirectionY += hoseDirectionVariance * ((Math.random() * 4 - 2) * startSpeed);
        incrementAge();
    }

    public int getColor() {
        return 0;
    }
}
