import java.util.*;
import java.util.stream.Collectors;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction
 * a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */
public class Problem28 {

    public static void main(String[] args) {
        Map<String, TreeSet<Integer>> numbers = new LinkedHashMap<>();
        int dDiff = 0;

        Arrays.asList("RD", "LD", "LU", "RU")
                .forEach(a -> numbers.put(a, new TreeSet<>()));
        numbers.entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey, e -> e.getValue().add(1)));

        for(int i = 1; i < 501; i++) {
            for(Map.Entry<String, TreeSet<Integer>> p : numbers.entrySet()) {
                p.getValue().add(p.getValue().last() + (dDiff += 2));
            }
        }

        Set<Integer> full = new HashSet<>();

        numbers.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey, e -> full.addAll(e.getValue())
        ));

        long total = 0;
        for(int f : full) {
            total += f;
        }

        System.out.println(total);
    }

}
