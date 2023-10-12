package person.models.appearance;

import person.models.appearance.enums.EyesColor;

public class Appearance {

    private final EyesColor eyes;
    private final Hair hair;

    public Appearance(final EyesColor eyes, final Hair hair) {
        this.eyes = eyes;
        this.hair = hair;
    }

    @Override
    public final String toString() {
        return String.format("Eyes:\t%1$s%nHair:\t%2$s", eyes.toString().toLowerCase(), hair);
    }
}
