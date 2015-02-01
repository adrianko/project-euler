/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem41 {

    public static void main(String[] args) {
        //a little slow but it works
        for (int i = 987654321; i >= 2; i--) {
            if (isPandigital(i)) {
                if(isPrime(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean isPandigital(int n) {
        String ns = String.valueOf(n);

        for (int i = 1; i <= ns.length(); i++) {
            if (!ns.contains(Integer.toString(i))) {
                return false;
            }
        }

        return true;
    }

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

}