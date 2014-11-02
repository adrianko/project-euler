import java.util.TreeSet;

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left
 * to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem37 {

    public static void main(String[] args) {
        int total = 0;
        for (int i : primeSieve(1000000)) {
            if (i < 10) {
                continue;
            }

            if (isPrime(i)) {
                boolean flag = true;
                for (int j = 1; j < Integer.toString(i).length(); j++) {
                    if (!isPrime((int) Math.floor(i / Math.pow(10, j)))) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    continue;
                }

                for (int j = Integer.toString(i).length(); j >= 1; j--) {
                    if (!isPrime((int) (i % Math.pow(10, j)))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    total += i;
                }
            }
        }

        System.out.println(total);
    }

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
