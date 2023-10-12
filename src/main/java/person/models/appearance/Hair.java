package person.models.appearance;

import person.models.appearance.enums.HairColor;

public class Hair {

    private static final int MAX_LENGTH = 4;
    private final int length;
    private final HairColor color;

    public Hair(final int length, final HairColor color) {
        this.length = length;
        this.color = color;
    }

    @Override
    public final String toString() {
        String displayText = "no";
        if (length > 0) {
            displayText = ((length > MAX_LENGTH) ? "long" : "short") + ", " + color.toString().toLowerCase();
        }

        return displayText;
    }
}
