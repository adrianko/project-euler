import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p/>
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the
 * sum of two abundant numbers.
 */
public class Problem23 {

    public static void main(String[] args) {
        Set<Integer> abundant = new TreeSet<Integer>();

        for (int n = 3; n <= 28123; n++) {
            int total = 1;
            Set<Integer> used = new HashSet<Integer>();

            for (int i = 2; i <= (Math.sqrt(n) + 1); i++) {
                if (n % i == 0) {
                    if (!used.contains(i)) {
                        total += i;
                        used.add(i);
                    }

                    if ((n / i) != i && !used.contains((n / i))) {
                        total += (n / i);
                        used.add((n / i));
                    }
                }
            }

            if (n < total) {
                abundant.add(n);
            }
        }
        
        Set<Integer> abundantSums = new TreeSet<Integer>();
        for (int i : abundant) {
            for (int j : abundant) {
                abundantSums.add(i + j);
            }
        }

        long abTotal = 0;
        for (int i = 1; i <= 28123; i++) {
            if(!abundantSums.contains(i)) {
                abTotal += (long) i;
            }
        }

        System.out.println(abTotal);

    }

}
