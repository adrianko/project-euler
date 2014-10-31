/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 3; i <= 20000000; i++) {
            char[] iC = Integer.toString(i).toCharArray();

            long total = 0;
            for (char d : iC) {
                int n = Character.getNumericValue(d);
                if (n > 0) {
                    total += factorial(n);
                } else {
                    total += 1;
                }
            }

            if (total == i) {
                count += total;
            }
        }

        System.out.println(count);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
