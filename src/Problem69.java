import java.util.TreeSet;

/**
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used
 * to determine the number of numbers less than n which are relatively prime to
 * n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and
 * relatively prime to nine, φ(9)=6.
 *
 * n	Relatively Prime	φ(n)	n/φ(n)
 * 2	1	1	2
 * 3	1,2	2	1.5
 * 4	1,3	2	2
 * 5	1,2,3,4	4	1.25
 * 6	1,5	2	3
 * 7	1,2,3,4,5,6	6	1.1666...
 * 8	1,3,5,7	4	2
 * 9	1,2,4,5,7,8	6	1.5
 * 10	1,3,7,9	4	2.5
 *
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 *
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */
public class Problem69 {

    public static void main(String[] args) {
        TreeSet<Integer> primes = primeSieve(1000000);
        int total = 1;

        for (int i : primes) {
            if (total * i > 1000000) {
                break;
            }

            total *= i;
        }

        System.out.println(total);
    }

    public static TreeSet<Integer> primeSieve(int limit) {
        boolean[] numberList = new boolean[limit + 1];
        TreeSet<Integer> primeList = new TreeSet<>();

        for (int i = 2; i <= limit; i++) {
            numberList[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (numberList[i]) {
                for (int j = i; i * j <= limit; j++) {
                    numberList[i * j] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (numberList[i]) {
                primeList.add(i);
            }
        }

        return primeList;
    }

}
