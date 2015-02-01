import java.util.TreeSet;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem41 {

    public static void main(String[] args) {
        TreeSet<Integer> primes = primeSieve(1000000000);

        for (int p : primes.descendingSet()) {
            if (isPandigital(p)) {
                
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

    public static TreeSet<Integer> primeSieve(int limit) {
        boolean[] numberList = new boolean[limit + 1];
        TreeSet<Integer> primeList = new TreeSet<>();

        for(int i = 2; i <= limit; i++) {
            numberList[i] = true;
        }

        for(int i = 2; i * i <= limit; i++) {
            if(numberList[i]) {
                for(int j = i; i * j <= limit; j++) {
                    numberList[i * j] = false;
                }
            }
        }

        for(int i = 2; i <= limit; i++) {
            if(numberList[i]) {
                primeList.add(i);
            }
        }

        return primeList;
    }

}