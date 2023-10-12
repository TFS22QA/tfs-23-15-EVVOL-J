package utils;

public class MyMath {

    public static int getDigitsSum(final int i) {
        int src;
        if (i < 0) {
            src = i * -1;
        } else {
            src = i;
        }
        int sum = 0;
        final String numberAsString = String.valueOf(src);
        final String[] digitsAsString = numberAsString.split("");
        for (String stringDigit : digitsAsString) {
            sum += Integer.parseInt(stringDigit);
        }
        return sum;
    }
}
