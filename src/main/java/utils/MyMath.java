package utils;

public class MyMath {

    public static int getDigitsSum(final int i) {
        int src=Math.abs(i);
        int sum = 0;
        final String numberAsString = String.valueOf(src);
        final String[] digitsAsString = numberAsString.split("");
        for (String stringDigit : digitsAsString) {
            sum += Integer.parseInt(stringDigit);
        }
        return sum;
    }
}
