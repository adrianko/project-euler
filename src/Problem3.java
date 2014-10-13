/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

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
        long n = 600851475143L;

        for (int i = 2; i <= n / 2; i++) {
            if (!isPrime(i)) {
                continue;
            }

            if (n % i > 0) {
                continue;
            }

            System.out.println(n + " " + i);
            n = n / i;

            if (isPrime(n)) {
                System.out.println("Done: " + n);
                break;
            }
        }

    }

}
