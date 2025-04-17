package Model;
public abstract class Particle {
    private int positionX;
    private int positionY;
    double velocityX;
    double velocityY;

    private int age = 0;
    static float gravity = 1.5f;
    static float airResistance = 0.9f;

    public Particle(ParticleEmitter p) {
        positionX = p.getPositionX();
        positionY = p.getPositionY();
    }
    public int getPositionX() {return positionX;}
    public int getPositionY() {return positionY;}
    public void setPositionX(int x) {positionX = x;}
    public void setPositionY(int y) {positionY = y;}
    public int getAge() {return age;} // returns the age of the particle counted by how many updates the particle has had.
    public abstract int getColor();
    void incrementAge() {age++;}
    double getSpeed() {return Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));} // Returns the startSpeed of the particle.
    public void updateParticle() {
        velocityY *= airResistance;
        velocityX *= airResistance;
        velocityY += gravity;
        positionX += velocityX;
        positionY += velocityY;
        incrementAge();
    }
    abstract boolean isAlive(); // Returns true if the particle is alive, false if it is dead.
    }