package person;

import person.models.Phone;
import utils.MyMath;

import java.util.Random;

import static generators.ParamGenerator.*;

public class PersonFactory {

    public static Person getPerson(final String code) {
        Phone phone = new Phone("N/A");
        int intCode=Integer.parseInt(code);

        // добавляем телефон, только если введённый код не палиндром

        if (!code.equals(new StringBuilder(code).reverse().toString())) {
            final String number = "+79"
                    + String.format("%02d", MyMath.getDigitsSum(intCode))
                    + String.format("%03d", new Random().nextInt(1000))
                    + String.format("%04d", intCode);
            phone = new Phone(number);
        }

        return new Person(
                code,
                lastNameGenerator(intCode),
                firstNameGenerator(intCode),
                middleNameGenerator(intCode),
                physicalGenerator(intCode),
                appearanceGenerator(intCode),
                phone
        );
    }
}
