import java.util.TreeSet;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem50 {

    public static void main(String[] args) {
        int limit = 1000000;
        TreeSet<Integer> primes = primeSieve(limit);
        int stash = 0;
        int currentCount = 0;

        for (int s : primes) {
            int start = 0;
            int count = 0;

            for (int p : primes) {
                if (s <= p) {
                    start += p;
                    count++;

                    if (primes.contains(start) && start != s && count > currentCount) {
                        currentCount = count;

                        if (start > stash) {
                            stash = start;
                        }
                    }

                    if (start >= limit) {
                        break;
                    }
                }
            }
        }

        System.out.println(stash);
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