import java.util.HashSet;
import java.util.Set;

/**
 * Euler discovered the remarkable quadratic formula:
 *
 * n^2 + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is
 * divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.
 *
 * The incredible formula  n^2 − 79n + 1601 was discovered, which produces 80
 * primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n^2 + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n
 *
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */
public class Problem27 {

    public static Set<Integer> primes = new HashSet<>();
    public static Set<Integer> notPrimes = new HashSet<>();

    public static void main(String[] args) {
        int top = 0;
        int product = 0;

        for (int a = -1000; a < 1000; a++) {
            for (int b = -1000; b < 1000; b++) {
                int n = 0;

                while (true) {
                    if (!isPrime(((int) Math.pow(n, 2)) + (a * n) + b)) {
                        break;
                    }

                    n++;
                }

                if (n >= top) {
                    product = a * b;
                    top = n;
                }
            }
        }

        System.out.println(product);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        if (primes.contains(n)) {
            return true;
        }

        if (notPrimes.contains(n)) {
            return false;
        }

        long sqrtN = (long) Math.sqrt(n) + 1;

        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                notPrimes.add(n);
                return false;
            }
        }

        primes.add(n);
        return true;
    }

}
