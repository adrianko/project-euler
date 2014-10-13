/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
public class Problem7 {

    public static boolean isPrime(long n) {
        if (n < 2)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        long sqrtN = (long) Math.sqrt(n) + 1;

        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int count = 1;
        int num = 3;

        while (count < 10001) {
            if (isPrime(num)) {
                count += 1;
            }

            if (count < 10001) {
                num += 2;
            }
        }

        System.out.println(num);
    }

}
