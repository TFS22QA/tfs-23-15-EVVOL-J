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
    public static Appearance gen_Ap(final int c) {
        final int i = c % 100 / 10;
        String e = EyesColor.values()[i / 2].name().toLowerCase();
        String hc = null;
        if (i > 0) {
            hc = HairColor.values()[i - 1].name().toLowerCase();
        }
        return new Appearance(e, new Hair(i, hc));
    }

    public static String lastNameGenerator(final int code) {
        final int i = getDigitsSum(code);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("lastNames_" + s).get(i);
    }

    public static String firstNameGeneration(final int code) {
        final int i = getDigitsSum(code);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("names_" + s).get(getDigitsSum(code / 100));
    }

    public static String middleNameGeneration(final int code) {
        final int i = getDigitsSum(code);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("middleNames_" + s).get(getDigitsSum(code % 100));
    }

    /**
     * по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120
     * Рост: 1..1,9
     */
    public static Physical GenPh(final int c) {
        final int x = c % 1000 / 100;
        int v = (x + 1) * 10;
        int k = 30 + x * 10;
        double naskolkovysokiychelovek = (100 + x * 10) / 100.00;
        return new Physical(v, k, naskolkovysokiychelovek);
    }


}
