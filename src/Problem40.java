import java.util.Arrays;
import java.util.List;

/**
 * An irrational decimal fraction is created by concatenating the positive
 * integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 * If dn represents the nth digit of the fractional part, find the value of the
 * following expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem40 {

    public static void main(String[] args) {
        String df = "";
        int i = 0;
        List<Integer> required = Arrays.asList(
                1,
                10,
                100,
                1000,
                10000,
                100000,
                1000000
        );

        while (df.length() <= 1000000) {
            df += String.valueOf(++i);
        }

        int total = 1;
        for (int pos : required) {
            total *= Character.getNumericValue(df.charAt(pos - 1));
        }

        System.out.println(total);
    }

}
