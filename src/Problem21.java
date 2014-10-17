import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public static void main(String[] args) {
        Map<Integer, Integer> divSums = new HashMap<Integer, Integer>();

        for (int n = 2; n < 10000; n++) {
            divSums.put(n, 1);
            Set<Integer> used = new HashSet<Integer>();

            for (int i = 2; i <= (Math.sqrt(n) + 1); i++) {
                if (n % i == 0) {
                    if (!used.contains(i)) {
                        divSums.put(n, divSums.get(n) + i);
                        used.add(i);
                    }

                    if ((n / i) != i && !used.contains((n / i))) {
                        divSums.put(n, (divSums.get(n) + (n / i)));
                        used.add((n / i));
                    }
                }
            }
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> p : divSums.entrySet()) {
            if (divSums.containsKey(p.getValue())) {
                if (divSums.get(p.getValue()).equals(p.getKey())
                        && !p.getKey().equals(p.getValue())) {
                    total += p.getValue();
                }

            }
        }

        System.out.println(total);
    }

}
