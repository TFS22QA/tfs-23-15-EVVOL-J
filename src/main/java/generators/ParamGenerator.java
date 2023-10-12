package generators;

import person.models.Phone;
import person.models.Physical;
import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;
import utils.MyMath;

import java.util.Random;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class ParamGenerator {

    public static final int ONE_HUNDRED = 100;
    public static final int TEN = 10;
    public static final int ONE_THOUSAND = 1000;
    public static final int RATIO = 30;
    private static final Random random = new Random();

    public static Phone phoneGenerator(String code) {
        Phone phone = new Phone("N/A");

        int intCode = Integer.parseInt(code);
        // добавляем телефон, только если введённый код не палиндром

        if (!code.contentEquals(new StringBuilder(code).reverse())) {
            final String number = "+79"
                    + String.format("%02d", MyMath.getDigitsSum(intCode))
                    + String.format("%03d", random.nextInt(1000))
                    + String.format("%04d", intCode);
            phone = new Phone(number);
        }
        return phone;
    }

    /**
     * по третьей цифре кода:
     * Глаза: 0..4
     * Длина волос: i
     * Цвет волос: 0..8.
     *
     * @return .
     */
    public static Appearance appearanceGenerator(final int code) {
        final int i = code % ONE_HUNDRED / TEN;
        EyesColor eyes = null;
        HairColor hairColor = null;
        if (i > 0) {
            eyes = EyesColor.values()[i / 2];
            hairColor = HairColor.values()[i - 1];
        }
        return new Appearance(eyes, new Hair(i, hairColor));
    }

    private static String getSex(int code, String fileName, int index) {
        final int i = getDigitsSum(code);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile(fileName + s).get(index);
    }

    public static String lastNameGenerator(final int code) {
        return getSex(code, "lastNames_", getDigitsSum(code));
    }

    public static String firstNameGenerator(final int code) {
        return getSex(code, "names_", getDigitsSum(code / ONE_HUNDRED));
    }

    public static String middleNameGenerator(final int code) {
        return getSex(code, "middleNames_", getDigitsSum(code % ONE_HUNDRED));
    }

    /**
     * по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120
     * Рост: 1..1,9
     */
    public static Physical physicalGenerator(final int code) {
        final int x = code % ONE_THOUSAND / ONE_HUNDRED;
        int age = (x + 1) * TEN;
        int weight = RATIO + x * TEN;
        double height = 1 + (double) x / TEN;
        return new Physical(age, weight, height);
    }
}
