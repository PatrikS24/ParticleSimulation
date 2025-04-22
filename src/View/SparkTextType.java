package View;

import Model.ParticleType;

public class SparkTextType extends ParticleTextType {
    SparkTextType() {
        type = ParticleType.SPARK;
    }
    public String toString() {
        return "Sparks";
    }
}
