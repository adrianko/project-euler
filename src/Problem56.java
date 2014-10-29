import java.math.BigInteger;

/**
 * A googol (10^100) is a massive number: one followed by one-hundred zeros;
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 *
 * Considering natural numbers of the form, ab, where a, b < 100, what is the
 * maximum digital sum?
 */
public class Problem56 {

    public static void main(String[] args) {
        int largest = 0;

        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                String pow = BigInteger.valueOf(a).pow(b).toString();

                int total = 0;
                for (char d : pow.toCharArray()) {
                    total += Character.getNumericValue(d);
                }

                if (total > largest) {
                    largest = total;
                }

            }
        }

        System.out.println(largest);
    }

}
