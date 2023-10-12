package person.models;

public class Phone extends Param {

    private final String number;

    public Phone(final String number) {
        this.number = number;
    }

    @Override
    public final String toString() {
        return "Phone:\t" + number;
    }
}
