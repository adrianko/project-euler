import java.util.ArrayList;
import java.util.TreeMap;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n / 2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
 * that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14 {

    public static void main(String[] args) {
        TreeMap<Integer, ArrayList<Integer>> chainLength =
                new TreeMap<Integer, ArrayList<Integer>>();

        for (int i = 1; i < 1000000; i++) {
            long r = i;
            int length = 0;

            while (r > 0) {
                if (r % 2 == 0) {
                    r = r / 2;
                } else {
                    r = (r * 3) + 1;
                }
                length++;

                if (r == 1) {
                    break;
                }
            }

            if (!chainLength.containsKey(length)) {
                chainLength.put(length, new ArrayList<Integer>());
            }

            chainLength.get(length).add(i);
        }

        System.out.println(chainLength.get(chainLength.lastKey()).get(0));

    }

}
