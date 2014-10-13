/**
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
public class Problem5 {

    public static void main(String[] args) {
        boolean f = false;
        long i = 2;

        while (!f) {
            for (int d = 2; d <= 20; d++) {
                if (i % d != 0) {
                    f = false;
                    break;
                }

                f = true;
            }

            if (!f) {
                i += 2;
            }
        }

        System.out.println(i);

    }

}
