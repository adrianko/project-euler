import java.util.HashSet;
import java.util.Set;

/**
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */
public class Problem35 {

    public static boolean isPrime(int n) {
        if(n <= 3) {
            return n >= 2;
        } else if(n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            for(int i = 5; i < (Math.sqrt(n) + 1); i+= 6) {
                if(n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Set<Integer> allPrimes = new HashSet<Integer>();
        for(int i = 2; i < 1000000; i++) {
            if(isPrime(i)) {
                allPrimes.add(i);
            }
        }

        for(int p : allPrimes) {
            char[] pStr = String.valueOf(p).toCharArray();
            int possPerms = factorial(pStr.length);

        }
    }

}
