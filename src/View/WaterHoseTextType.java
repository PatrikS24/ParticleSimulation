package View;

import Model.ParticleType;
import Model.WaterHose;

public class WaterHoseTextType extends ParticleTextType {
    WaterHoseTextType() {
        type = ParticleType.WATERHOSE;
    }
    public String toString() {
        return "WaterHose";
    }
}
