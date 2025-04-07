package Particlelogic;
public abstract class Particle {
    int positionX;
    int positionY;
    double velocityX;
    double velocityY;

    int age = 0;
    static float gravity = 2;

    public Particle(ParticleEmitter p) {
        positionX = p.positionX;
        positionY = p.positionY;
    }
    abstract void updateParticle(); //updates position, velocity and life status of a particle.
    abstract boolean isAlive(); // Returns true if the particle is alive, false if it is dead.
    int getAge() {return age;} // returns the age of the particle counted by how many updates the particle has had.
    public int getPositionX() {return positionX;}
    public int getPositionY() {return positionY;}
    double getSpeed() {return velocityX + velocityY;} // Returns the startSpeed of the particle.
}
