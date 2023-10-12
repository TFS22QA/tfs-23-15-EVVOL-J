package person.models.appearance;

public class Appearance {

    private final String eyes;
    private final Hair hair;

    public Appearance(final String eyes, final Hair hair) {
        this.eyes = eyes;
        this.hair = hair;
    }

    @Override
    public final String toString() {
        return String.format("Eyes:\t%1$s%nHair:\t%2$s", eyes, hair);
    }
}
