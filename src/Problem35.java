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
        if (n <= 3) {
            return n >= 2;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            for (int i = 5; i < (Math.sqrt(n) + 1); i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Set<Integer> rotate(int n) {
        Set<Integer> rotations = new HashSet<>();
        String nS = Integer.toString(n);

        for (int i = 0; i < nS.length(); i++) {
            nS = nS.substring(1) + nS.charAt(0);
            rotations.add(Integer.parseInt(nS));
        }

        return rotations;
    }

    public static void main(String[] args) {
        int count = 0;

        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                boolean prime = true;

                for (int j : rotate(i)) {
                    if (!isPrime(j)) {
                        prime = false;
                        break;
                    }
                }

                if (prime) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
