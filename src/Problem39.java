import java.util.*;

/**
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem39 {

    public static void main(String[] args) {
        Map<Integer, Integer> p = new HashMap<>();
        TreeMap<Integer, Integer> sorted = new TreeMap<>(new ValueComparator(p));

        for (int a = 1; a < 999; a++) {
            for (int b = 1; b < 999; b++) {
                for (int c = 1; c <= 1000; c++) {
                    if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                        if (a + b + c > 1000) {
                            continue;
                        }

                        if (!p.containsKey(a + b + c)) {
                            p.put(a + b + c, 0);
                        }

                        int t = p.get(a + b + c);
                        p.put(a + b + c, ++t);
                    }
                }
            }
        }

        sorted.putAll(p);

        System.out.println(sorted.firstKey());
    }

    static class ValueComparator implements Comparator<Integer> {

        Map<Integer, Integer> base;

        public ValueComparator(Map<Integer, Integer> b) {
            base = b;
        }


        @Override
        public int compare(Integer a, Integer b) {
            if (base.get(a) < base.get(b)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}

