package View;

import Model.ParticleType;

public class EmberTextType extends ParticleTextType{
    EmberTextType() {
        type = ParticleType.EMBER;
    }
    public String toString() {
        return "Ember";
    }
}
