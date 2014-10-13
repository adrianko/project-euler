import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class Problem20 {

    public static BigInteger factorial(int n) {
        if(n == 1) {
            return BigInteger.valueOf(1);
        }

        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {
        BigInteger result = factorial(100);
        String resultS = String.valueOf(result);

        int total = 0;
        for(char r : resultS.toCharArray()) {
            total += Character.getNumericValue(r);
        }

        System.out.println(total);
    }

}
