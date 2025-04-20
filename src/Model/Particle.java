package Model;
public abstract class Particle {
    protected int positionX;
    protected int positionY;
    protected double velocityX;
    protected double velocityY;

    private int age = 0;
    int lifespan = (int)(Math.random() * 50 - 30) + 30;

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
    void incrementAge() {++age;}
    double getSpeed() {return Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));}
    public abstract void updateParticle();
    public boolean isAlive() {return getAge() < lifespan;}
}