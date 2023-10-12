package generators;

import person.models.Physical;
import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class ParamGenerator {

    /**
     * по третьей цифре кода:
     * Глаза: 0..4
     * Длина волос: i
     * Цвет волос: 0..8.
     *
     * @return .
     */
    public static Appearance appearanceGenerator(final int code) {
        final int i = code % 100 / 10;
        EyesColor eyes = EyesColor.values()[i / 2];
        HairColor hairColor = null;
        if (i > 0) {
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
        return getSex(code, "names_", getDigitsSum(code / 100));
    }

    public static String middleNameGenerator(final int code) {
        return getSex(code, "middleNames_", getDigitsSum(code % 100));
    }

    /**
     * по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120
     * Рост: 1..1,9
     */
    public static Physical physicalGenerator(final int code) {
        final int x = code % 1000 / 100;
        int age = (x + 1) * 10;
        int weight = 30 + x * 10;
        double height = (100 + x * 10) / 100.00;
        return new Physical(age, weight, height);
    }
}
