package View;

import Model.ParticleType;

public abstract class ParticleTextType {
    public ParticleType type;
    public abstract String toString();
    public ParticleType getType() {return type;}
}
