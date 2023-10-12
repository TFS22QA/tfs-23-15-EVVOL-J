package person.models;

public class Physical extends Param {

    private final int age;
    private final int weight;
    private final double height;

    public Physical(final int age, final int weight, final double height) {
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public final String toString() {
        return String.format("Age:\t%1$s%nWeight:\t%2$s kg%nHeight:\t%3$s m", age, weight, height);
    }
}
