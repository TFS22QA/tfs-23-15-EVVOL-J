package generators;

import person.models.Passport;
import person.models.Physical;
import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;

import java.util.Random;

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
    public Appearance gen_Ap(final int c) {
        final int i = c % 100 / 10;
        String e = EyesColor.values()[i / 2].name().toLowerCase();
        String hc = null;
        if (i > 0) {
            hc = HairColor.values()[i - 1].name().toLowerCase();
        }
        return new Appearance(e, new Hair(i, hc));
    }

    /**
     * сумма цифр в коде.
     */
    public String lngeneration(final int c) {
        final int i = getDigitsSum(c);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("lastNames_" + s).get(i);
    }

    /**
     * сумма первых двух цифр.
     */
    public String fngeneration(final int c) {
        final int i = getDigitsSum(c);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("names_" + s).get(getDigitsSum(c / 100));
    }

    /**
     * сумма последних двух цифр.
     */
    public String mngeneration(final int c) {
        final int i = getDigitsSum(c);
        final String s = (i % 2 == 0) ? "f" : "m";
        return getLinesFromFile("middleNames_" + s).get(getDigitsSum(c % 100));
    }

    /**
     * по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120
     * Рост: 1..1,9
     */
    public Physical GenPh(final int c) {
        final int x = c % 1000 / 100;
        int v = (x + 1) * 10;
        int k = 30 + x * 10;
        double naskolkovysokiychelovek = (100 + x * 10) / 100.00;
        return new Physical(v, k, naskolkovysokiychelovek);
    }

    /**
     * Генерация номера паспорта.
     *
     * @param c код
     * @return номер паспорта
     */
    public Passport pNumGen(final int c) {
        final int d = 999999;
        final String pn = String.valueOf(c) + new Random().nextInt(d);
        return new Passport(pn);
    }
}
