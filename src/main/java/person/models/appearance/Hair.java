package person.models.appearance;

public class Hair {

    private static final int MAX_LENGTH = 4;
    private final int length;
    private final String color;

    public Hair(final int length, final String color) {
        this.length = length;
        this.color = color;
    }

    @Override
    public final String toString() {
        String displayText = "no";
        if (length > 0) {
            displayText = ((length > MAX_LENGTH) ? "long" : "short") + ", " + color;
        }

        return displayText;
    }
}
