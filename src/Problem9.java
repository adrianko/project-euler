/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {

    public static void main(String[] args) {
        /**
         * (m < n)
         * a = n^2 - m^2
         * b = 2nm
         * c = n^2 + m^2
         */
        loop:
        for (int m = 1; m <= 300; m++) {
            for (int n = 2; n <= 300; n++) {
                int a = (int) (Math.pow(n, 2) - Math.pow(m, 2));
                int b = 2 * n * m;
                int c = (int) (Math.pow(n, 2) + Math.pow(m, 2));

                if ((a + b + c) == 1000) {
                    System.out.println(a * b * c);
                    break loop;
                }
            }
        }
    }

}
