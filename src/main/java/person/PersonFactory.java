package person;

import static generators.ParamGenerator.*;

public class PersonFactory {

    public static Person getPerson(final String code) {
        int intCode = Integer.parseInt(code);
        return new Person(
                code,
                lastNameGenerator(intCode),
                firstNameGenerator(intCode),
                middleNameGenerator(intCode),
                physicalGenerator(intCode),
                appearanceGenerator(intCode),
                phoneGenerator(code)
        );
    }

}
