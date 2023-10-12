import person.PersonFactory;

public class InputProcessor {

    public final String processInput(final String input) {
        String result;

        if (!input.trim().matches("\\d{4}")) {
            result = "Invalid input.";
        } else {
            result = PersonFactory.getPerson(input).toString();
        }
        return result;
    }
}
